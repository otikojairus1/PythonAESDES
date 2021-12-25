
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.*;  
import java.io.UnsupportedEncodingException;

class AES {
	// Class private variables
	private static final String SECRET_KEY
		= "maryamssuperpassword";
		
	private static SecretKeySpec secretKey;
    private static byte[] key;
	
	private static final String SALT = "vyuyugugu";

	// This method used for encryption of the string
	public static String encrypt(String strToEncrypt)
	{
		try {

			// Create default byte array
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec
				= new IvParameterSpec(iv);

			// Create SecretKeyFactory object
			SecretKeyFactory factory
				= SecretKeyFactory.getInstance(
					"PBKDF2WithHmacSHA256");
			
			
			KeySpec spec = new PBEKeySpec(
				SECRET_KEY.toCharArray(), SALT.getBytes(),
				65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(
				tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance(
				"AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey,
						ivspec);
			// Returning encrypted string
			return Base64.getEncoder().encodeToString(
				cipher.doFinal(strToEncrypt.getBytes(
					StandardCharsets.UTF_8)));
		}
		catch (Exception e) {
			System.out.println("Encryption error: "
							+ e.toString());
		}
		return null;
	}

	// decryption method
	public static String decrypt(String strToDecrypt)
	{
		try {

			// Default byte array
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0 };
			// Create IvParameterSpec object and assign with
			// constructor
			IvParameterSpec ivspec
				= new IvParameterSpec(iv);

			// Create SecretKeyFactory Object
			SecretKeyFactory factory
				= SecretKeyFactory.getInstance(
					"PBKDF2WithHmacSHA256");

			// Create KeySpec object and assign with
			// constructor
			KeySpec spec = new PBEKeySpec(
				SECRET_KEY.toCharArray(), SALT.getBytes(),
				65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(
				tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance(
				"AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey,
						ivspec);
			// Return decrypted string
			return new String(cipher.doFinal(
				Base64.getDecoder().decode(strToDecrypt)));
		}
		catch (Exception e) {
			System.out.println("Error while decrypting: "
							+ e.toString());
		}
		return null;
	}
	
	
 public static String encryptECB(String strToEncrypt) 
    {
    try
        {
            setKey("mysecretkry");
             //SecretKey secretKey = "klasiodasdhiausuiai";
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Encryption error: " + e.toString());
        }
        return null;
    }
    
    //setting key for ecb
   public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    	// This method use to encrypt to string
	public static String encryptOFB(String strToEncrypt)
	{
		try {

			// Create default byte array
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec
				= new IvParameterSpec(iv);

			// Create SecretKeyFactory object
			SecretKeyFactory factory
				= SecretKeyFactory.getInstance(
					"PBKDF2WithHmacSHA256");
			
			// Create KeySpec object and assign with
			// constructor
			KeySpec spec = new PBEKeySpec(
				SECRET_KEY.toCharArray(), SALT.getBytes(),
				65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(
				tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance(
				"AES/OFB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey,
						ivspec);
			// Return encrypted string
			return Base64.getEncoder().encodeToString(
				cipher.doFinal(strToEncrypt.getBytes(
					StandardCharsets.UTF_8)));
		}
		catch (Exception e) {
			System.out.println("Encryption error: "
							+ e.toString());
		}
		return null;
	}
	
	  	// This method use to encrypt to string USING CFB
	public static String encryptCFB(String strToEncrypt)
	{
		try {

			// Create default byte array
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec
				= new IvParameterSpec(iv);

			// Create SecretKeyFactory object
			SecretKeyFactory factory
				= SecretKeyFactory.getInstance(
					"PBKDF2WithHmacSHA256");
			
			// Create KeySpec object 
			// the constructor
			KeySpec spec = new PBEKeySpec(
				SECRET_KEY.toCharArray(), SALT.getBytes(),
				65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(
				tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance(
				"AES/CFB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey,
						ivspec);
			// Return encrypted string
			return Base64.getEncoder().encodeToString(
				cipher.doFinal(strToEncrypt.getBytes(
					StandardCharsets.UTF_8)));
		}
		catch (Exception e) {
			System.out.println("theres an error in the encryption: "
							+ e.toString());
		}
		return null;
	}
	
		  	// This method use to encrypt to string USING Ctr
	public static String encryptCTR(String strToEncrypt)
	{
		try {

			// Create default byte array
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec
				= new IvParameterSpec(iv);

			// Create SecretKeyFactory object
			SecretKeyFactory factory
				= SecretKeyFactory.getInstance(
					"PBKDF2WithHmacSHA256");
			
			// Create KeySpec object and assign with
			// constructor
			KeySpec spec = new PBEKeySpec(
				SECRET_KEY.toCharArray(), SALT.getBytes(),
				65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(
				tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance(
				"AES/CTR/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey,
						ivspec);
			// Return encrypted string
			return Base64.getEncoder().encodeToString(
				cipher.doFinal(strToEncrypt.getBytes(
					StandardCharsets.UTF_8)));
		}
		catch (Exception e) {
			System.out.println("encryption error "
							+ e.toString());
		}
		return null;
	}

}


  
// driver code
public class Main {
	public static void main(String[] args)
	{
		// Create String variables
		String originalString = "MaryamAlmalki201707408";
		
		// Call encryption method
		String encryptedString
			= AES.encrypt(originalString);
		//ecb
			String encryptedECB
			= AES.encryptECB(originalString);
			//OFB
			String encryptedOFB
			= AES.encryptOFB(originalString);
			//CFB
				String encryptedCFB
			= AES.encryptCFB(originalString);
				//CTR
				String encryptedCTR
			= AES.encryptCTR(originalString);
		// CallING decryption method
		String decryptedString
			= AES.decrypt(encryptedString);

// 		// Printing all strings
// 		System.out.println(originalString);
// 		System.out.println(encryptedString);
// 		System.out.println(decryptedString);
		//ecb
			
			
// 		//OFB
// 			System.out.println(encryptedOFB);
// 			//CFB
// 			System.out.println(encryptedCFB);
// 			//CTR
// 			System.out.println(encryptedCTR);
// 			//ecb
// 			System.out.println(encryptedString);
// 			//handling user input
			
			Scanner sc= new Scanner(System.in);    //Asking user for the mode input 
System.out.print("Choose the mode for encryption from the options  - 1.ECB 2. OFB  3.CFB  4.CTR 5. CBC  ");  
int a= sc.nextInt();

if (a == 1)
{
    System.out.println(encryptedECB);
}else if (a == 2){
    System.out.println(encryptedOFB);
}else if (a == 3){
    	System.out.println(encryptedCFB);
// 			
}else if (a == 4){
    
    	System.out.println(encryptedCTR);
}else{
    	System.out.println(encryptedCTR);
}
	}
}
