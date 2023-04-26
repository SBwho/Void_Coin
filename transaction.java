import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class transaction {
    public String FromAddress;
    public String ToAddress;
    public int Amount;

    public transaction(String FromAddress,String ToAddress,int Amount){
        this.FromAddress=FromAddress;
        this.ToAddress= ToAddress;
        this.Amount= Amount;
    }


    public String calculateHash() {
        String data = this.FromAddress + this.ToAddress + this.Amount;
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = digest.digest(data.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

   
/*
 * const SHA256= require('crypyo-js/sha256'); // imported the library

class transaction{
    
    calculateHash(){
        return SHA256(this.fromaddress+this.toaddress+ this.amount).toString();

    }
    signtranscation(signingkey){
        if(signingkey,getpublic('hex')!=this.fromaddress){
            throw new Error(" you cannot sign transcationfor the wallets");
        }


        const hashtx = this.calculateHash();
        const sig = signingkey.sign(hashtx,'based64');
        this.signature = sig.toDer('hex');
    }
    isvalid(){
        if(this.fromaddress=== null ) return true;
        if (!this.signature|| this.signature.length===0)
    {throw new Error(" no sign in this transcation");}
    const publickey = ec.keyfrompublic   
    }
}

// crpto are powerby peer to peer network
class Block{
    constructor(index,timestamp,data,previousHash=""){
        //index will tell where the block sit
        // timestamp will tell us when it was created
        //data can be anytype of data like how much money was transfered
        // who was the sender and who was the receiver
        //hash is a string contain hash of the block 
        this.index=index; // position in the array
        this.timestamp=timestamp;
        this.data=data;
        this.previousHash=previousHash;
        this.hash=this.calculateHash;// this will contain the hash of our block so 
        // we can calculate it
        this.nonce=0;
    }
    //calculate hash method
    // cal hash function of this block
    // install crypto js npm install --save crypto-js library
    calculateHash(){
        return SHA256  (this.index+this.previousHash+this.timestamp+JSON.stringify(this.data)+this.nonce).toString();
        // this line is custed to string

    }
    mineblock(diffcillty){
        while(this.hash.substring(0,diffcillty)!== Array(diffcillty+1).join("0")){
            this.nonce++;
            this.calculateHash= this.calculateHash();

        }
        console.log("block mined; "+ this.hash);
    }
    hasvalidtransctions(){
        for(const tx of this.transaction){
            if(!tx.isvalid()){
                return false;
            }
        }
        return true;
    }
}


class blockchain{
    constructor(){
        this.chain=[this,this.createGenesisBlock]; // array of blocks first block of the blockchain 
        // is called the genesis block so this should be added manually
        this.diffcillty=2;
        this.pendingtransction=[];
        this.miningReward=100;

    }
    createGenesisBlock(){
        return new Block(0,"1/1/23","genesisblock","0");
    }
    getlastestblock(){
        // it return the lastest block in the chain 
        return this.chain[this.chain.length-1];
    }
   /* addBlock(newBlock){
        // this block is responsble for adding new block to the chain
        newBlock.previousHash= this.getlastestblock().hash;
        // in newblock we store the hash of the lastest block of the chain
        newBlock.mineblock(this.diffcillty);
        //newBlock.hash= newBlock,calculateHash();// this method will update the hash for new legder
        this.chain.push(newBlock);// this will push to new block chain 



    minePendingtransction(miningRewardaddress){
        let block = new Block(date.now(),this.pendingtransction);
        block.mineblock(this.diffcillty);
        
        console.log("block susscefully mined! ");
        this.chain.push(block);
        this.pendingtransction=[
            new transaction(null,miningRewardaddress,this.miningReward)
        ];
    }    
    addtransction(data){
        if(!data.fromaddress||!data.toaddress){
            throw new Error("transaction must include from, and to address");
        }
        if(!transaction.isvalid()){
            throw new Error ("cannot add invalid transaction to chain");

        }
        this.pendingtransction.push(data); // this will receive a transaction 
        // add it to the pending area

    }
    getbalanceaddress(address){
        let balance =0;
        for(const block of this.chain){
        for(const trans of Block.data){
            if(trans.fromaddress==address){
                balance-=trans.amount;

            }
            if(trans.toaddress===address){
                balance +=trans.amount;

            }
        }
    }
    return balance;
    }
    ischainValid(){ // return true and false
        for(let i =1;i<this.chain.length;i++){
            const currentblock = this.chain[i];
            const previousblock = this.chain[i-1];
            if(!currentblock.hasvalidtransctions()){
                return false;

            }
            if(currentblock.hash!=currentblock.calculateHash())
            {
                return false;
            }
            if(currentblock.previousHash!==previousblock.hash())
            {
                return false;
            }
        }
        return true;

    }
}

let savjeecoin = new blockchain();

const tx1 = new transaction(mywalletaddress,'public key goes here', 10 );
tx1.signtranscation(mykey);
savjeecoin.addtransction(tx1);


//console.log(JSON.stringify(savjeecoin,null,4));
// proof of work
console.log("mining block 1...");
savjeecoin.addBlock(new Block(1,"10/07/2019",{amount:4}));//amount is data object
console.log("mining block 1...");
savjeecoin.addBlock(new Block(2,"10/07/2019",{amount:10}));//amount is data object


// creating transction
savjeecoin.createtransction(new transaction('address1','address2 ',100));
savjeecoin.createtransction(new transaction('address2','address1 ',50));
// in realty address1 and address2 will be the  public key of someones wallet
console.log("\n starting the miner! ");
savjeecoin.minePendingtransction("mywalletaddeìress");

console.log('\nbalance of xaviers ', savjeecoin.getbalanceaddress("mywalletaddeìress"));

console.log("\n starting the miner!2  ");
savjeecoin.minePendingtransction("xaviers address");

console.log('\nbalance of xaviers ', savjeecoin.getbalanceaddress("xaviers address"));
const mykey=ec.keyfromprivate("sakdj124251");
const mywalletaddress=mykey.getpublic("hex");


const ec= require('elliptic').ec;  // this is a library

const ec = new ec (' scep256k1');

const key= ec.getkeypair();
const publickey= ec.getkeypair();
const privatekey= ec.getkeypair();

console.log();
console.log('privatekey: ',privatekey);
console.log();
console.log('public key : ',publickey);
*/
