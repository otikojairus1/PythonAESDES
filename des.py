from Crypto.Cipher import DES

def pad(text):
    n = len(text) % 8
    return text + (b' ' * n)


key = b'maryamalmarr2017'
decryptionText = b'maryamalmarr2017Thisisamessage'

des = DES.new(key, DES.MODE_ECB)

padded_text = pad(decryptionText)
encrypted_text = des.encrypt(padded_text)

print(encrypted_text)
print(des.decrypt(encrypted_text))