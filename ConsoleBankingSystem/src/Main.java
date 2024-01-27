import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

// This class contains the main method to run the banking system.
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        while (true) {
            try {
                System.out.println("\n$$$$Welcome to el bank banking system$$$$");
                System.out.println("\nNew here! sign up now by clicking (1)");
                System.out.println("\nAlready have an account sign in by clicking (2)");
                System.out.println("\nExit by clicking (3)");
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();
                input.nextLine(); // consume newline
                if (choice == 1) {
                    while (true) {
                        System.out.println("\nEnter username");
                        String username = input.nextLine();//existingUser
                        System.out.println("Enter password");
                        String password = input.nextLine();
                        try {
                            Account account = bank.createAccount(username, password);
                            break;

                        } catch (IllegalArgumentException e) {
                            System.out.println(("Username and Password cant be Empty ...Please try again"));
                        }catch (Exception e){
                            System.out.println("Username is already exist...Please try different one ");
                        }
                    }
                    System.out.println("Account is set successfully....Back to the main menu");
                } else if (choice == 2) {
                    System.out.println("Enter username");
                    String username = input.nextLine();
                    System.out.println("Enter password");
                    String password = input.nextLine();
                    Optional<Account> account = bank.getAccount(username, password);
                    if (account.isPresent()) {
                        System.out.println("Welcome back : " + username);
                        bank.operate(account.get());
                    } else {
                        System.out.println("Invalid username or password");
                    }
                } else if (choice == 3) {
                    System.out.println("Thank you for using el bank banking system. Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input... Please enter a number.");
            }
        }
    }
}
