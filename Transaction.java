

public class Transaction {

    private Cilent sender;
    private Cilent receiver;
    private double amount;

    public Transaction(Cilent sender, Cilent receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public Cilent getSender() {
        return sender;
    }

    public Cilent getreceiver() {
        return receiver;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return " " + sender.getId() + " sent " + amount + " bitcoins to " + receiver.getId();
    }
}