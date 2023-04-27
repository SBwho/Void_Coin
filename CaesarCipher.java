import java.security.MessageDigest;
import java.util.Arrays;

public class CaesarCipher {
    public static String hash_repr_hex(byte[] hashed){
        String sum = "";
        for (byte x : hashed) {
            sum = sum + String.format("%x", x);
        }
        return sum;
    }
    public static void main(String[] args) {
        String initial_message = "a";
        try{
        byte[] message = initial_message.getBytes("UTF-8");

        // As MessageDigest is an abstract class it cannot be instantiated 
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");
        System.out.println(hasher.getDigestLength());
        byte[] hashed_data = hasher.digest(message);
        System.out.println(Arrays.toString(hashed_data));
        System.out.println(CaesarCipher.hash_repr_hex(hashed_data));
        }
        catch(Exception NoSuchAlgorithmException){
            System.out.println("something went wrong");
        }
            }

}
