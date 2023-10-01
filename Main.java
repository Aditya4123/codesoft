import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return this.balance;
    }
}

class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Quit");
    }

    public void run() {
        while (true) {
            displayOptions();
            System.out.print("Select an option (1/2/3/4): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter the amount to withdraw: ");
                double amount = Double.parseDouble(scanner.nextLine());
                if (userAccount.withdraw(amount)) {
                    System.out.println("Withdrew " + amount + " successfully.");
                } else {
                    System.out.println("Insufficient funds or invalid amount.");
                }
            } else if (choice.equals("2")) {
                System.out.print("Enter the amount to deposit: ");
                double amount = Double.parseDouble(scanner.nextLine());
                if (userAccount.deposit(amount)) {
                    System.out.println("Deposited " + amount + " successfully.");
                } else {
                    System.out.println("Invalid amount.");
                }
            } else if (choice.equals("3")) {
                System.out.println("Account Balance: " + userAccount.checkBalance());
            } else if (choice.equals("4")) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial account balance: ");
        double initialBalance = Double.parseDouble(scanner.nextLine());
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
