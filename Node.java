import java.math.BigInteger;

public class Node {
    private BigInteger private_key;
    private BigInteger public_key;
    private BigInteger modulus;
    private String[] transactions;
    private String first_name;
    private String last_name;

    Node(String first_name,String last_name){
        BigInteger[] key_pair = Key.generate_keys();
        this.first_name = first_name;
        this.last_name = last_name;
        this.private_key = key_pair[1];
        this.public_key = key_pair[0];
        this.modulus = key_pair[2];
    }

    public void SendBitcoin(Node receiver, float amount){

    }

    public BigInteger[] get_public_key (){
        BigInteger[] pair = {public_key, modulus};
        return pair;      
    }

    public void mesasge_sign(){

    }
}
