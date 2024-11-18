import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1001;  // Starting account number
    }

    public void createAccount(String name, String password) {
        Account newAccount = new Account(name, password, nextAccountNumber++);
        accounts.add(newAccount);
        System.out.println("Account created successfully with account number: " + newAccount.getAccountNumber());
    }

    public Account findAccount(int accountNumber, String password) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber && account.authenticate(password)) {
                return account;
            }
        }
        return null;
    }

    public void deleteAccount(int accountNumber, String password) {
        Account account = findAccount(accountNumber, password);
        if (account != null) {
            accounts.remove(account);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found or incorrect password.");
        }
    }

    public void transferFunds(int senderAccountNumber, int recipientAccountNumber, double amount) {
        Account sender = getAccountByNumber(senderAccountNumber);
        Account recipient = getAccountByNumber(recipientAccountNumber);

        if (sender != null && recipient != null && sender.getBalance() >= amount) {
            sender.withdraw(amount);
            recipient.deposit(amount);
            sender.addTransaction("Transferred $" + amount + " to Account #" + recipientAccountNumber);
            recipient.addTransaction("Received $" + amount + " from Account #" + senderAccountNumber);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Check account numbers and balance.");
        }
    }

    private Account getAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}
