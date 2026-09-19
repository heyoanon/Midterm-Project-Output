import java.util.Random;
import java.util.Scanner;

public class GuessingNumberGame {
    public static void main(String[] args) {

        // Create objects for random number generation and user input
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        // Set the maximum number of attempts per game
        int maxAttempts = 10;

        // Overall game statistics
        int totalGamesPlayed = 0;
        int totalGamesWon = 0;
        int totalGamesLost = 0;
        int bestScore = 0;
        int totalAttemptsAllGames = 0;

        // Variable used to determine whether the player wants another game
        int tryAgain;

        do {

            // Generate a random number from 1 to 100
            int numberToGuess = random.nextInt(100) + 1;

            // Variables for the current game
            int guess = 0;
            int attempts = 0;
            int totalGuess = 0;

            // Set initial values for highest and lowest guesses
            int highestGuess = Integer.MIN_VALUE;
            int lowestGuess = Integer.MAX_VALUE;

            // Determines whether the player successfully guessed the number
            boolean won = false;

            // Display the game introduction
            System.out.println("\n==================================");
            System.out.println("   WELCOME TO GUESS THE NUMBER");
            System.out.println("==================================");
            System.out.println("Guess the number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");
            System.out.println();

            // Continue asking for guesses until the player wins
            // or reaches the maximum number of attempts
            while (attempts < maxAttempts) {

                System.out.print("Guess: ");
                guess = sc.nextInt();

                // Count the current attempt
                attempts++;

                // Add the guess to the total for calculating the average
                totalGuess += guess;

                // Check and update the highest guess
                if (guess > highestGuess) {
                    highestGuess = guess;
                }

                // Check and update the lowest guess
                if (guess < lowestGuess) {
                    lowestGuess = guess;
                }

                // Check if the guess is correct
                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed the number!");
                    won = true;
                    break;
                }

                // Give the player a hint
                else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                }

                else {
                    System.out.println("Too low!");
                }

                // Display remaining attempts
                if (attempts < maxAttempts) {
                    System.out.println("Attempts remaining: "
                            + (maxAttempts - attempts));
                }
            }

            // If the player did not guess correctly,
            // the game is considered lost
            if (!won) {
                System.out.println("\nMaximum attempts reached!");
                System.out.println("The secret number was: " + numberToGuess);
            }

            // Calculate the average of all guesses in the current game
            double averageGuess = (double) totalGuess / attempts;

            // Update overall game statistics
            totalGamesPlayed++;
            totalAttemptsAllGames += attempts;

            if (won) {
                totalGamesWon++;

                // Update the best score if this is the first win
                // or if the player used fewer attempts
                if (bestScore == 0 || attempts < bestScore) {
                    bestScore = attempts;
                }
            }
            else {
                totalGamesLost++;
            }

            // Display statistics for the current game
            System.out.println("\n========== GAME STATISTICS ==========");
            System.out.println("Secret Number: " + numberToGuess);
            System.out.println("Attempts: " + attempts);
            System.out.println("Highest Guess: " + highestGuess);
            System.out.println("Lowest Guess: " + lowestGuess);
            System.out.printf("Average Guess: %.2f%n", averageGuess);

            // Ask the player whether they want to play again
            do {
                System.out.println("\n1. Try Again");
                System.out.println("2. Exit");
                System.out.print("Choose: ");

                tryAgain = sc.nextInt();

                // Validate the player's choice
                if (tryAgain != 1 && tryAgain != 2) {
                    System.out.println(
                        "Invalid choice, please enter 1 or 2."
                    );
                }

            } while (tryAgain != 1 && tryAgain != 2);

        } while (tryAgain == 1);

        // Calculate the average number of attempts across all games
        double averageAttempts =
                (double) totalAttemptsAllGames / totalGamesPlayed;

        // Display the overall statistics
        System.out.println("\n======================================");
        System.out.println("       OVERALL GAME STATISTICS");
        System.out.println("======================================");
        System.out.println("Total Games Played: " + totalGamesPlayed);
        System.out.println("Total Games Won: " + totalGamesWon);
        System.out.println("Total Games Lost: " + totalGamesLost);

        // Only display a best score if the player won at least one game
        if (bestScore > 0) {
            System.out.println("Best Score: " + bestScore + " attempts");
        }
        else {
            System.out.println("Best Score: No winning score yet");
        }

        System.out.printf("Average Attempts: %.2f%n", averageAttempts);

        // Close the Scanner
        sc.close();
    }
}
