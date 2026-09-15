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
         }
      } 
      // Add numbers 3-7 from the instructions 
  }
}
