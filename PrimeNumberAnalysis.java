import java.util.Scanner;

public class PrimeNumberAnalysis {

   // Helper method to check if a number is prime
   public static boolean isPrime(int n) {
      if (n < 2) return false;
      for (int i = 2; i * i <= n; i++) {
         if (n % i == 0) return false;
      }
      return true;   
   }      
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      System.out.print("Enter a number: ");
      int N = sc.nextInt();
      
      // Variables for tracking stats
      int count = 0;
      int smallestPrime = -1;
      int largestPrime = -1;
      long sum = 0;
      
      // Variables for tracking the prime gap
      int previousPrime = -1;
      int currentPrime = -1;
      int largestGap = 0;
      
      System.out.println("==== PRIME ANALYSIS ====");
      System.out.println("\nPrimes]n");
      
      // Loop through all numbers up to N
      for (int i = 2; i <=N; i++) {
         if (isPrime(i)){
         // Print the prime number
         System.out.print(i + " ");
         // Increase the total number of primes
         totalPrime++;

          // Add the prime to the total sum
         sum += i;

         // Set the smallest prime
         // The first prime encountered is the smallest
         if (smallestPrime == -1) {
            smallestPrime = i;
         }

         // Update the largest prime
         largestPrime = i;

         // Calculate the gap between the current
         // prime and the previous prime
         if (previousPrime != -1) {

               int gap = i - previousPrime;

               // Update the largest gap if necessary
               if (gap > largestGap) {
                  largestGap = gap;
               }
            }

            // Store the current prime as the previous prime
            previousPrime = i;
         }
      }

      System.out.println();

      // Check if at least one prime number was found
      if (totalPrime > 0) {

         // Calculate the average of all prime numbers
         double average = (double) sum / totalPrime;

         // Display the prime number statistics
         System.out.println("\nTotal Primes: " + totalPrime);
         System.out.println("Smallest Prime: " + smallestPrime);
         System.out.println("Largest Prime: " + largestPrime);
         System.out.println("Sum: " + sum);
         System.out.printf("Average: %.2f%n", average);
         System.out.println("Largest Gap: " + largestGap);

      } else {

         // Display this message if there are no primes
         System.out.println("No prime numbers found.");
      }

      // Close the Scanner
      sc.close();

      // Add numbers 3-7 from the instructions 
  }
}
