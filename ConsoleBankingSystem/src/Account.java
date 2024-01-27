// This class represents a bank ac   count.
public class Account {
    private String username;  // The username of the account holder
    private String password;  // The password of the account
    private double balance;  // The balance of the account
    private int number;

    // Constructor for the Account class
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0;  // Initial balance is set to 0
    }
    public Account(int number){
        this.number=number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // Method to set the balance of the account
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be positive");
        }
        this.balance = balance;
    }

    // Checks if the provided password matches the account password
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    // Getter for the balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
        System.out.println("Money is added successfully");
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Your balance is not enough to make this withdraw");
        }
        this.balance -= amount;
        System.out.println("Money withdrawn successfully");
    }

    // Method to transfer money from this account to another
    public void transfer(Account other, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Your balance is not enough to make this transfer");
        }
        this.balance -= amount;
        System.out.println("Money has been withdrawn from your account for the transfer");
        other.deposit(amount);
        System.out.println("Money has been deposited to the other account");
    }

    // Method to check the balance of the account
    public void checkBalance() {
        System.out.println("Your balance is: " +getBalance());
    }
}
