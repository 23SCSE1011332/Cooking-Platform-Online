import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Account\n2. Login\n3. Delete Account\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    bank.createAccount(name, password);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    Account account = bank.findAccount(accountNumber, password);
                    if (account != null) {
                        accountOptions(bank, account, scanner);
                    } else {
                        System.out.println("Incorrect credentials.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    bank.deleteAccount(accountNumber, password);
                    break;
                case 4:
                    System.out.println("Thank you for using our Banking System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void accountOptions(Bank bank, Account account, Scanner scanner) {
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Transfer Funds\n5. View Transaction History\n6. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Balance: $" + account.getBalance());
                    break;
                case 4:
                    System.out.print("Enter recipient account number: ");
                    int recipientAccountNumber = scanner.nextInt();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    bank.transferFunds(account.getAccountNumber(), recipientAccountNumber, transferAmount);
                    break;
                case 5:
                    account.printTransactionHistory();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

