import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash{
    
    public static String hashValue(String message)throws NoSuchAlgorithmException{
        // Create a message digest object using SHA-256 algorithm
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        
        // Generate the hash value of the input string
        byte[] hashBytes = md.digest(message.getBytes());
        
        // Convert the byte array to a hexadecimal string representation
        String hashString = byte_to_hex(hashBytes);
        return hashString;
    }

    public static String hashValue(String[] message) throws NoSuchAlgorithmException{
        StringBuilder sb = new StringBuilder();
        for (String s : message) {
            sb.append(s);
        }
        String inputString = sb.toString();
        
        // Create a message digest object using SHA-256 algorithm
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        
        // Generate the hash value of the input string
        byte[] hashBytes = md.digest(inputString.getBytes());
        
        // Convert the byte array to a hexadecimal string representation
        String hashString = byte_to_hex(hashBytes);
        return hashString;
    }

    public static String byte_to_hex(byte[] hashed){
        StringBuilder sb = new StringBuilder();
        for (byte b : hashed) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static BigInteger hex_to_int(String hash){
        return new BigInteger(hash,16);
    }

}
    
