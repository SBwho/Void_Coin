import hashlib
def Main(select_num):
    
    if select_num=='1':
        data= input(" enter your data\n ")
        length=len(data)
        if length==0:
            print('no data has been inputed default HASH')
            print(hashlib.sha256(b"").hexdigest())
        else:
            print("Your hash code is:")
            hashing = hashlib.sha256(data.encode()).hexdigest()
            print(hashing)
            
    elif select_num=='2':
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
        
    elif select_num=='3':
 
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

           
select_nums=input(" 1 or 2 or 3 \n")
Main(select_nums) 
            
            




