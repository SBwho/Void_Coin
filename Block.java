import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Block {
    
    private static final String[] ArrayList = null;
    private int index;
    private String previousHash;
    private String[] data;
    private String timestamp;
    public String hash;

    Block(int index, String timestamp, String[] data,String previousHash) throws NoSuchAlgorithmException{
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }


    private String calculateHash() throws NoSuchAlgorithmException {
        String value = Integer.toString(index) + timestamp + previousHash;

        for(String s: data){
            value += s;
        }
        return Hash.hashValue(value);
    }
    
}
