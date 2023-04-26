import java.math.BigInteger;
import java.security.SecureRandom;

public class keyGenerator {
    public static void main(String[] args) {
        
    
    //Generate a new RSA key pair
    SecureRandom random = new SecureRandom();
    BigInteger p = BigInteger.probablePrime(11, random);
    BigInteger q = BigInteger.probablePrime(11, random);
    BigInteger n = p.multiply(q);
    BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    BigInteger e = BigInteger.valueOf(65537);
    BigInteger d = e.modInverse(phi);

     //Get the private key
    BigInteger privateKey = d;

    // Calculate the public key
    BigInteger publicKey = e;

    // Print the public and private keys
    System.out.println("Private key: " + privateKey);
    System.out.println("Public key: " + publicKey);
}
}
