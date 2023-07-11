import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        WorkZone network = new WorkZone();
        Blockchain blockchain = new Blockchain();

        System.out.println("Welcome to Void Coin");

        Cilent cilent1 = new Cilent("cilent 1");
        Cilent cilent2 = new Cilent("cilent 2");
        Cilent cilent3 = new Cilent("cilent 3");
        Miner miner1 = new Miner("Miner_1", blockchain);
        Miner miner2 = new Miner("Miner_2", blockchain);

        network.addMiner(miner1);
        network.addMiner(miner2);
        network.addCilent(cilent1);
        network.addCilent(cilent2);
        network.addCilent(cilent3);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Send transaction from cilent 1 to cilent 2");
            System.out.println("2. Send transaction from cilent 2 to cilent 3");
            System.out.println("3. Send transaction from cilent 3 to cilent 1");
            System.out.println("4. Add a new client");
            System.out.println("5. Print balances");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to send from cilent 1 to cilent 2: ");
                    int amount1 = scanner.nextInt();
                    network.sendTransaction(cilent1, cilent2, amount1);
                    break;
                case 2:
                    System.out.print("Enter the amount to send from cilent 2 to cilent 3: ");
                    int amount2 = scanner.nextInt();
                    network.sendTransaction(cilent2, cilent3, amount2);
                    break;
                case 3:
                    System.out.print("Enter the amount to send from cilent 3 to cilent 1: ");
                    int amount3 = scanner.nextInt();
                    network.sendTransaction(cilent3, cilent1, amount3);
                    break;
                case 4:
                    scanner.nextLine(); // Clear the input buffer
                    System.out.print("Enter the name of the new client: ");
                    String newClientName = scanner.nextLine();
                    Cilent newClient = new Cilent(newClientName);
                    network.addCilent(newClient);
                    System.out.println("New client added: " + newClientName);
                    System.out.print("\nIncase you don't want to send Void Coin Press 0\n3Enter the sender (1, 2, or 3): ");
                    int senderChoice = scanner.nextInt();
                    Cilent sender = null;
                    switch (senderChoice) {
                        case 1:
                            sender = cilent1;
                            break;
                        case 2:
                            sender = cilent2;
                            break;
                        case 3:
                            sender = cilent3;
                            break;
                        default:
                            System.out.println("Invalid sender choice. Please try again.");
                            break;
                    }
                    if (sender != null) {
                        System.out.print("Enter the amount to send to the new client: ");
                        int amount = scanner.nextInt();
                        network.sendTransaction(sender, newClient, amount);
                    }
                    break;
                case 5:
                    network.printBalances();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
