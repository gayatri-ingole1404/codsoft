import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
            "Which of the given is an interpreted language?",
            "Who is the inventor of Linux?",
            "What is the largest planet in our solar system?",
            "Which language is primarily used for data science?",
            "What is the chemical symbol for water?"
        };

        String[][] options = {
            {"1) Python", "2) HTML", "3) C", "4) Git"},
            {"1) Isaac Newton", "2) Linus Torvalds", "3) Ryan Gosling", "4) Marie Curie"},
            {"1) Earth", "2) Mars", "3) Jupiter", "4) Saturn"},
            {"1) Python", "2) Java", "3) C", "4) ASM 64"},
            {"1) O2", "2) H2O", "3) CO2", "4) NaCl"}
        };

        int[] answers = {1, 2, 3, 1, 2}; 

        int score = 0;
        int questionTimeLimit = 30; 

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.println("You have " + questionTimeLimit + " seconds to answer...");

            TimerThread timerThread = new TimerThread(scanner, questionTimeLimit);
            Thread thread = new Thread(timerThread);
            thread.start();

            try {
                thread.join(questionTimeLimit * 3000); 

                if (thread.isAlive()) {
                    
                    thread.interrupt(); 
                    System.out.println("Time's up! Moving to the next question.");
                } else {
                    int userAnswer = timerThread.getUserAnswer();
                    if (userAnswer == answers[i]) {
                        System.out.println("Correct!");
                        score++;
                    } else {
                        System.out.println("Incorrect! The correct answer was " + options[i][answers[i] - 1]);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
        }

        System.out.println("Quiz Over!");
        System.out.println("Your final score is: " + score + " out of " + questions.length);
        scanner.close();
    }
}

class TimerThread implements Runnable {
    private Scanner scanner;
    private int timeLimit;
    private int userAnswer = -1;

    public TimerThread(Scanner scanner, int timeLimit) {
        this.scanner = scanner;
        this.timeLimit = timeLimit;
    }

    public void run() {
        try {
            if (scanner.hasNextInt()) {
                userAnswer = scanner.nextInt();
            }
        } catch (Exception e) {
            
        }
    }

    public int getUserAnswer() {
        return userAnswer;
    }
}