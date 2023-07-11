import java.util.ArrayList;
import java.util.List;

public class Cilent {
    private String id;
    private double balance;
    private List<Transaction> transactionHistory;

    public Cilent(String id) {
        this.id = id;
        this.balance = 10;
        this.transactionHistory = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getHistory() {
        return transactionHistory;
    }



    public boolean sendTransaction(Cilent receiver, double amount) {
        if (balance >= amount) {
            balance -= amount;
            receiver.receiveTransaction(amount);
            transactionHistory.add(new Transaction(this, receiver, amount));
            return true; // Transaction successful
        } else {
            return false; // Insufficient balance, transaction failed
        }
    }

    public void receiveTransaction(double amount) {
        balance += amount;
    }

}

