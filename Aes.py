from Crypto.Cipher import AES


#Prompting user for input mode

print("please select your encryption mode: 1. ECB 2. CBC 3. OFB 4.CFB 5.CTR")
response = input("specify the number ")

#
if response == 1:
    mode = AES.MODE_ECB
elif response == 2:
    mode = AES.MODE_CBC
elif response == 3:
    mode = AES.MODE_OFB
elif response == 4:
    mode = AES.MODE_CFB
elif response == 5:
    mode = AES.MODE_CTR
else:
    print("Error in mode selection: invalid option")
 
key = 'maryamalmarr2017'
 
cipher = AES.new(key, mode)
message =cipher.encrypt('mynameismaryamalmarr')
print (type(message))
 
print(message.encode("hex"))
 #deciphering 
decipher = AES.new(key, AES.MODE_ECB)
print(decipher.decrypt(message))
