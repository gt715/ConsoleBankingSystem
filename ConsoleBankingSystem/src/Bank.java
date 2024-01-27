import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Optional;

// This class represents a bank that manages multiple accounts.
public class Bank {
    // A map of accounts where the key is the username and the value is the Account object
    private final HashMap<String, Account> accounts = new HashMap<>();



    //  making an existing Account
    public Bank() {
        // Pre-existing account
        Account existingAccount = new Account("existingUser", "existingPassword");
        accounts.put("existingUser", existingAccount);
        // Constructor for the Bank class
        existingAccount.setBalance(5000);  // Set an initial balance of 5000
        accounts.put("existingUser", existingAccount);
    }

    // Method to create a new account

    public   Account  createAccount(String username, String password) throws Exception {
        if (username == null || username.isEmpty()) {
//            throw new Exception("Username and Password cannot be empty");
            throw new IllegalArgumentException();
        } else if ((password == null || password.isEmpty())) {
            throw new IllegalArgumentException();

        } else if (accounts.containsKey(username)) {
            throw new Exception();

        } else {
            Account account = new Account(username, password);
            accounts.put(username, account);
            return account;
        }
    }




    // Method to get an account given a username and password
    // Returns an Optional<Account> which will be empty if the account does not exist or the password is incorrect
    public Optional<Account> getAccount(String username, String password) {
        Account account = accounts.get(username);
        if (account != null && account.checkPassword(password)) {
            return Optional.of(account);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Account>getAccount(int number ){
        Account account=new Account(number);
        return Optional.of(account);
    }



    // Method to perform operations on an account
    // Continuously prompts the user for operations until they choose to logout
    public void operate(Account account) {
        UserInterface ui = new UserInterface();
        while (true) {
            try {
                Operation operation = ui.getOperation();
                switch (operation) {
                    case DEPOSIT:
                        double depositAmount = ui.getAmount();
                        account.deposit(depositAmount);
                        break;
                    case WITHDRAW:
                        double withdrawAmount = ui.getAmount();
                        account.withdraw(withdrawAmount);
                        break;
                    case TRANSFER:
                        int accountNum = ui.getAccount();

                        Optional<Account> otherAccount = getAccount(accountNum);
                        if (otherAccount.isPresent()) {
                            double transferAmount = ui.getAmount();
                            System.out.println("Press Enter to continue...");
                            ui.clearInput();  // Wait for user to press Enter

                            System.out.println("Initiating transfer...");
                            account.transfer(otherAccount.get(), transferAmount);
                            System.out.println("Transfer successful!");
                        } else {
                            System.out.println("The specified account does not exist or the password is incorrect");
                        }
                        break;

                    case CHECK_BALANCE:
                        account.checkBalance();
                        break;
                    case LOGOUT:
                        ui.logout();
                        return;  // This ends the loop and the method
                    case INVALID:
                        System.out.println("Invalid operation. Please try again.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Returning to main menu...");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                ui.clearInput();
                System.out.println("Returning to main menu...");
            }
        }
    }
}
