import java.util.Scanner;

public class ATM {
    private UserDatabase userDatabase;
    private Scanner scanner;

    public ATM() {
        userDatabase = new UserDatabase();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        Account account = userDatabase.getAccount(accountNumber);

        if (account == null) {
            System.out.println("Invalid Account Number!");
            return;
        }

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        if (!account.authenticate(pin)) {
            System.out.println("Invalid PIN!");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.print("Enter recipient account number: ");
                    String recipientAcc = scanner.next();
                    Account recipient = userDatabase.getAccount(recipientAcc);
                    if (recipient == null) {
                        System.out.println("Invalid recipient account number.");
                        break;
                    }
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    if (account.transfer(recipient, transferAmount)) {
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Transfer failed due to insufficient funds.");
                    }
                    break;
                case 5:
                    account.printTransactionHistory();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

