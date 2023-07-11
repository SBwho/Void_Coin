import java.util.ArrayList;
import java.util.List;

public class WorkZone {
    private List<Cilent> cilents;
    private List<Miner> miners;

    public WorkZone() {
        this.cilents = new ArrayList<>();
        this.miners = new ArrayList<>();
    }

    public void addCilent(Cilent cilent) {
        cilents.add(cilent);
    }

    public void addMiner(Miner miner) {
        miners.add(miner);
    }

    public void sendTransaction(Cilent sender, Cilent receiver, double amount) {
        try {
            boolean successful = sender.sendTransaction(receiver, amount);
            if (successful) {
                System.out.println("Transaction: " + sender.getId() + " sent " + amount + " bitcoins to " + receiver.getId());
            } else {
                System.out.println("Transaction failed: " + sender.getId() + " does not have sufficient balance.");
            }
            printBalances();
        } catch (Exception e) {
            System.out.println("Transaction failed due to an error: " + e.getMessage());
        }
    }

    public void printBalances() {
        System.out.println("Cilent Balances:");
        for (Cilent cilent : cilents) {
            System.out.println(cilent.getId() + ": " + cilent.getBalance() + " bitcoins");
        }
        System.out.println();
    }
}
