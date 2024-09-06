import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.print("Enter the number of rounds you want to play: ");
        int rounds = scanner.nextInt();

        for (int roundNum = 1; roundNum <= rounds; roundNum++) {
            System.out.println("\nRound " + roundNum);
            int number = random.nextInt(100) + 1; 
            int attempts = 0;
            int maxAttempts = 10;
            int roundScore = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Guess the number (between 1 and 100): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < number) {
                    System.out.println("Too low!");
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    roundScore = maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + number + ".");
            }

            totalScore += roundScore;
            System.out.println("Round " + roundNum + " Score: " + roundScore);
            System.out.println("Total Score: " + totalScore);
        }

        System.out.println("\nGame Over! Your final score is " + totalScore + ". Thanks for playing!");
        scanner.close();
    }
}