import java.math.BigInteger;

public class CaesarCipher {
    public static void main(String[] args) {
        String message = "This is a secret message";
        BigInteger shift = new BigInteger("123");
         BigInteger[] private_key ={new BigInteger("17"),new BigInteger("3233")};
        BigInteger [] public_key = {new BigInteger("2753"),new BigInteger("3233")};
        int s = shift.intValue();
        
        
        // Convert the message to a char array
        char[] chars = message.toCharArray();
        
        // Encrypt each character in the message
        for (int i = 0; i < chars.length; i++) {
            // Shift the character by the specified amount
            char c = chars[i];
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) (((c - base + s) % 26) + base);
            }
            chars[i] = c;
        }
        // Convert the encrypted char array back to a string and print it to the console
        String encryptedMessage = new String(chars);
        System.out.println("Encrypted message: " + encryptedMessage);
        shift = createSecretShift(private_key, shift);
        System.out.println("hello "+shift);

                String encryptedMessage2 = encryptedMessage;
                BigInteger shift1 = getshiftkey(public_key, shift);
               int f = shift1.intValue();
               System.out.println("hello "+shift1);
                // Convert the encrypted message to a char array
                char[] chars1 = encryptedMessage2.toCharArray();
                
                // Decrypt each character in the encrypted message
                for (int i = 0; i < chars1.length; i++) {
                    // Shift1shift1 the character back by the specified amount
                    char c = chars1[i];
                    if (Character.isLetter(c)) {
                        char base = Character.isUpperCase(c) ? 'A' : 'a';
                        c = (char) (((c - base - f) % 26 + 26) % 26 + base);
                    }
                    chars1[i] = c;
                }
                
                // Convert the decrypted char array back to a string and print it to the console
                String decryptedMessage = new String(chars1);
                System.out.println("Decrypted message: " + decryptedMessage);
            }
        public static BigInteger getshiftkey(BigInteger[] public_key,BigInteger secret_shift){
            return (secret_shift.pow(2753)).mod(public_key[1]);

        }

        public static BigInteger createSecretShift (BigInteger[] private_key,BigInteger shift){
            return (shift.pow(17)).mod( private_key[1]);
        }

}
