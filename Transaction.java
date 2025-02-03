public class Transaction {
    private String type;
    private double amount;
    private String accountNumber;

    public Transaction(String type, double amount, String accountNumber) {
        this.type = type;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return type + ": $" + amount + " (Account: " + accountNumber + ")";
    }
}

