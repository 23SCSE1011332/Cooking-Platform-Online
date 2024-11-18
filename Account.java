import java.util.ArrayList;

public class Account {
    private String name;
    private String password;
    private int accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String name, String password, int accountNumber) {
        this.name = name;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created.");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for Account #" + accountNumber + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

