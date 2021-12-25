import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
 
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
 
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
 
public class DES {
 
    private static Cipher mycipher;
    private static Cipher decryptcipher;
 
    private static SecretKey key;
 
    public static void main(String[] args) {
 
        try {
 
            // generating a sectret key
            key = KeyGenerator.getInstance("DES").generateKey();
 
            mycipher = Cipher.getInstance("DES");
            decryptcipher = Cipher.getInstance("DES");
 
            // cypher initialization
 
  mycipher.init(Cipher.ENCRYPT_MODE, key);
 
  decryptcipher.init(Cipher.DECRYPT_MODE, key);
 
  String encrypted = encryptionfunction("MaryamAlmalki201707408");
 
  String decrypted = decryptionfunction(encrypted);
 
  System.out.println("Decrypted string is: " + decrypted);
 
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println("Wrong algorithm used:" + e.getMessage());
            return;
        }
        catch (NoSuchPaddingException e) {
            System.out.println("Wrong padding specified:" + e.getMessage());
            return;
        }
        catch (InvalidKeyException e) {
            System.out.println("you used an invalid key:" + e.getMessage());
            return;
        }
 
    }
 
    public static String encryptionfunction(String str) {
 
  try {
 
    // encode the string into a sequence of bytes using the named charset
 
    // storing the result into a new byte array. 
 
    byte[] utf8 = str.getBytes("UTF8");
 
byte[] enc = mycipher.doFinal(utf8);
 
// encode to base64
 
enc = BASE64EncoderStream.encode(enc);
 
return new String(enc);
 
  }
 
  catch (Exception e) {
 
    e.printStackTrace();
 
  }
 
  return null;
 
    }
 
    public static String decryptionfunction(String str) {
 
  try {
 
    // decode with base64 to get bytes
 
byte[] dec = BASE64DecoderStream.decode(str.getBytes());
 
byte[] utf8 = decryptcipher.doFinal(dec);
 
// create new string based on the specified charset
 
return new String(utf8, "UTF8");
 
  }
 
  catch (Exception e) {
 
    e.printStackTrace();
 
  }
 
  return null;
 
    }
 
}