import java.util.InputMismatchException;
import java.util.Scanner;

// This class handles user input and output.
public class UserInterface {
    // Scanner object to read user input
    private static final Scanner input = new Scanner(System.in);

    // Method to get the operation the user wants to perform
    // Continuously prompts the user until a valid operation is chosen
    public Operation getOperation() {
        while (true) {
            try {
                System.out.println("\nPlease choose your operation from the following options:");
                System.out.println("(1) Deposit");
                System.out.println("(2) Withdraw");
                System.out.println("(3) Money Transfer");
                System.out.println("(4) Check Balance");
                System.out.println("(5) Log Out\n");
                int choice = input.nextInt();
                return switch (choice) {
                    case 1 -> Operation.DEPOSIT;
                    case 2 -> Operation.WITHDRAW;
                    case 3 -> Operation.TRANSFER;
                    case 4 -> Operation.CHECK_BALANCE;
                    case 5 -> Operation.LOGOUT;
                    default -> Operation.INVALID;
                };
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // clear the invalid input
            }
        }
    }

    // Method to get the amount for deposit, withdrawal, or transfer operations
    // Continuously prompts the user until a valid amount is entered
    public double getAmount() {
        while (true) {
            try {
                System.out.println("\nPlease enter the money amount:");
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // clear the invalid input
            }
        }
    }

    // Method to handle user logout
    public void logout() {
        System.out.println("\nThank you for using our banking system. Have a nice day!\n");
    }

    // Method to clear invalid input
    public void clearInput() {
        input.nextLine();
    }

    // Method to get the username for transfer operation
    public int getAccount(){
        while(true) {
            try {
                System.out.println("\nPlease enter the acccount number ");
                return input.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invaild input.... Please enter a vaild account number");
                input.nextLine();
            }
        }
    }


    // Method to get the password for transfer operation
    // Continuously prompts the user until a valid password is entered
    public String getPassword() {
        while (true) {
            try {
                System.out.println("\nPlease enter the password of the account you want to transfer to:");
                return input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid password.");
                input.nextLine(); // clear the invalid input
            }
        }
    }
}
