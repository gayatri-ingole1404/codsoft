import java.util.*;

public class ATM {
    private double balance = 1000.0;

    public void display() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("\nEnter your choice:: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to withdraw: ");
                    withdraw(input.nextDouble());
                    break;
                case 2:
                    System.out.println("Enter amount to deposit: ");
                    deposit(input.nextDouble());
                    break;
                case 3:
                    CheckBalance();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful!");
    }
    public void CheckBalance()
    {
        System.out.println("Your balance is: " + balance);

    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.display();
    }
}