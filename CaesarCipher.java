import java.security.MessageDigest;
import java.util.Arrays;
import java.lang.Integer;

public class CaesarCipher {
    public static String hash_repr_hex(byte[] hashed){
        String sum = "";
        for (int x : hashed) {
            //System.out.println(Integer.toHexString(x));
            //x=(x<0)?-x:x;
            sum = sum + Integer.toBinaryString(x);
        }
        return sum;
    }
    public static void main(String[] args) {
        String initial_message = "This is a secret message";
        try{
        byte[] message = initial_message.getBytes("UTF-8");

        // As MessageDigest is an abstract class it cannot be instantiated 
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");
        System.out.println(hasher.getDigestLength());
        int hashed_data = hasher.digest(message,3,5);
        //System.out.println(Arrays.toString(hashed_data));
        //System.out.println(CaesarCipher.hash_repr_hex(hashed_data));
        System.out.println(hashed_data);
        }
        catch(Exception NoSuchAlgorithmException){
            System.out.println("something went wrong");
        }
            }

}
