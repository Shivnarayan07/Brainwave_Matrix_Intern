import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private String pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            return true;
        }
        return false;
    }

    public boolean transfer(Account receiver, double amount) {
        if (withdraw(amount)) {
            receiver.deposit(amount);
            transactionHistory.add("Transferred: $" + amount + " to " + receiver.getAccountNumber());
            return true;
        }
        return false;
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
