import java.util.Random;
import java.util.Scanner;

public class GuessingNumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        
        int maxAttempts = 10;
        int gamesPlayed = 0;
        int gamesWon = 0;
        int gamesLost = 0;
        int bestScore = Integer.MAX_VALUE;
        int totalAttemptsAllGames = 0;
        
        boolean keepPlaying = true;
        
        while (keepPlaying) {
         int secretNumber = random.nextInt(100);
         int attempts = 0; 
         int totalGuessSum = 0;
         int highestGuess = Integer.MAX_VALUE;
         boolean won = false;
         
         System.out.println("Guess the number between 1 and 100.");
         
         while (attempts < maxAttempts) {
            System.out.print("Guess: ");
            int guess = sc.nextInt();
            attempts ++;
            totalGuessSum += guess;
            
            if (guess > highestGuess) highestGuess = guess;
            if (guess > lowestGuess) lowestGuess = guess;
            
            if (guess == secret {
               System.out.println("You have guessed the number!");
               won = true;
               break;
            }
            else if (guess > secret) {
               System.out.println("Too high!");
            }
            else {
               System.out.println("Too low!");
            }
      }
      if (!won) {
         System.out.println("Maximum attempts reached! Secret number was: " + secret);
      }
            
         }
        }
     
//set parameters and code to run the program.

  }
}
