import hashlib
data= input(" enter your data\n ")
length=len(data)
if length==0:
    print('no data has been inputed default HASH')
    
    print(hashlib.sha256(b"").hexdigest())
else:
    print("Your hash code is:")
    hashing = hashlib.sha256(data.encode()).hexdigest()
    print(hashing)
    

#e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855
#6b51d431df5d7f141cbececcf79edf3dd861c3b4069f0b11661a3eefacbba918sad