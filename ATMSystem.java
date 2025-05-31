import java.util.*;


class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// User class
class User {
    private String name;
    private int pin;
    private BankAccount account;

    public User(String name, int pin, BankAccount account) {
        this.name = name;
        this.pin = pin;
        this.account = account;
    }

    public boolean validatePin(int inputPin) {
        return this.pin == inputPin;
    }

    public BankAccount getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }
}

// Transaction class
class Transaction {
    private String type;
    private double amount;
    private Date timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return timestamp + " - " + type + ": $" + amount;
    }
}

// ATM class
class ATM {
    private User user;
    private List<Transaction> transactions;
    private Scanner scanner;

    public ATM(User user) {
        this.user = user;
        this.transactions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();

        if (user.validatePin(enteredPin)) {
            System.out.println("Welcome, " + user.getName());
            showMenu();
        } else {
            System.out.println("Incorrect PIN. Access Denied.");
        }
    }

    private void showMenu() {
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: $" + user.getAccount().getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    user.getAccount().deposit(deposit);
                    transactions.add(new Transaction("Deposit", deposit));
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    if (user.getAccount().withdraw(withdraw)) {
                        transactions.add(new Transaction("Withdrawal", withdraw));
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 4:
                    System.out.println("Transaction History:");
                    if (transactions.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        for (Transaction t : transactions) {
                            System.out.println(t);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 5);
    }
}

// ATMSystem (Main class)
public class ATMSystem {
    public static void main(String[] args) {
        // Create a test account and user
        BankAccount account = new BankAccount("ACC123", 1000.00);
        User user = new User("Alice", 1234, account);
        ATM atm = new ATM(user);
        atm.start();
    }
}
