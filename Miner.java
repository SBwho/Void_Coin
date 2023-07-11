import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Miner {
    private String id;
    private Blockchain blockchain;

    public Miner(String id, Blockchain blockchain) {
        this.id = id;
        this.blockchain = blockchain;
    }

    public String getId() {
        return id;
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }

    public void mine(Transaction transaction) {
        // Simulated mining process
        int nonce = 0;
        String previousBlockHash = blockchain.getLatestBlockHash();
        String newBlockHash = calculateBlockHash(nonce, previousBlockHash, transaction);

        // Solve the proof-of-work puzzle
        while (!isValidBlockHash(newBlockHash)) {
            nonce++;
            newBlockHash = calculateBlockHash(nonce, previousBlockHash, transaction);
        }

        // Once a valid block hash is found, construct a new block and add it to the blockchain
        Block newBlock = new Block(previousBlockHash, newBlockHash, transaction);
        blockchain.addBlock(newBlock);

        // Update the latest block hash in the blockchain
        blockchain.setLatestBlockHash(newBlockHash);
    }


    private String calculateBlockHash(int nonce, String previousBlockHash, Transaction transaction) {
        // Simulated block hash calculation
        String data = nonce + previousBlockHash + transaction.toString();
        return simpleHash(data);
    }

    private boolean isValidBlockHash(String blockHash) {
        // Simulated validation of the block hash
        return blockHash.startsWith("0000"); // Simple proof-of-work condition
    }

    private String simpleHash(String data) {
        // Basic hash function - Sum of ASCII values of characters in the string
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(data.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
}
}
