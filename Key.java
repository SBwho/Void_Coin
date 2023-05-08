import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

public class Key {
    private static List<BigInteger> private_keys;

    public static BigInteger[] generate_keys(){

        BigInteger[] key_pair = {};
        //Generate a new RSA key pair
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(11, random);
        BigInteger q = BigInteger.probablePrime(11, random);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e;
        while (true){
            e = BigInteger.valueOf(random.nextInt(phi.intValue())); // generates a random number
            if ((iterativeGCD(e,phi).equals(BigInteger.valueOf(1))) && !(private_keys.isEmpty()?true:private_keys.contains(e))){
                //checks if the generated number is a relative prime to phi and is not in the list of private keys
                private_keys.add(e);
                break;
            }
        }
    
        BigInteger d = e.modInverse(phi);

        key_pair[0] = d; //public key
        key_pair[1] = e; // private_key
        key_pair[2] = n; //modulus
        
        return key_pair;
    }
    
    private static BigInteger iterativeGCD(BigInteger a, BigInteger b) {
        BigInteger tmp;
        while (!b.equals(BigInteger.valueOf(0))) {
            if (a.compareTo(b) < 1 ) {
                tmp = a;
                a = b;
                b = tmp;
            }
            tmp = b;
            b = a.mod(b);
            a = tmp;
        }
        return a;
    }
}
