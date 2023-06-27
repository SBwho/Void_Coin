import hashlib

block=1
nonce=1
data1='hello'# if she/ he want to input some data

data= input(" enter your data\n ")
length=len(data)
if length==0:
    data1="no data has been inputed default HASH"
    zeros=hashlib.sha256(b"").hexdigest()
    for i in zeros:
        count=4
        j=0
        while j>count:
            if (i!='0'):
                print("ok")
            j+=1
    #print("no zeros")
else:
    hashing = hashlib.sha256(data.encode()).hexdigest()
    
print("block: ", block)
print("\nNonce: ", nonce)
print("\nData: ", data)
if length==0:
    print("\ndata1: ",hashlib.sha256(b"").hexdigest())
    
else:
    print("\nHash: ",hashing)