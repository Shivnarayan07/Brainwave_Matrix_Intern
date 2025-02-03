import java.util.HashMap;

public class UserDatabase {
    private HashMap<String, Account> accounts;

    public UserDatabase() {
        accounts = new HashMap<>();
        // Sample Accounts
        accounts.put("12345", new Account("12345", "1234", 5000));
        accounts.put("67890", new Account("67890", "5678", 3000));
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}

