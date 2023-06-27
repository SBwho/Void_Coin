import hashlib

def get_hash_for_data():
    print("Your hash code is:")
    data= input(" enter your data\n ")
    length=len(data)
    if length==0:
        print(hashlib.sha256(b"").hexdigest())
        return
    else:
        hashing = hashlib.sha256(data.encode()).hexdigest()
        add_zero(hashing,data) 

def add_zero(GetHash,data):
    re=data
    zeroes='0000'+GetHash
    #print(zeroes)
    add_data_char_code(zeroes,re)

def add_data_char_code(data,zeros):
    d1=data
    total = 0
    for char in d1:
        total += ord(char)

    sign_hash=d1+str(total)
    #print("ok", d1)
    #print(total)
    print(sign_hash)

get_hash_for_data()