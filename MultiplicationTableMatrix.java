import java.util.Scanner;

public class MultiplicationTableMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter maximum number: ");
        int max = sc.nextInt();
        
        int largestValue = 0;
        int sumOfValues = 0;
        int evenCount = 0;
        int oddCount = 0;
        
        System.out.println();
        for (int row = 1; row <= max; row++) {
         for (int col = 1; col <= max; col++) {
            int product = row * col;
            System.out.printf("%4d", product);
            
            // Update stats
            if (product > largestValue) {
               largestValue = product;
            }
            if (product % 2 == 0) {
               evenCount++;
            } 
            else {
            oddCount++;
            }
         }

      }

        System.out.println("\n--- Statistics ---");
        System.out.println("Largest value: " + largestValue);
        System.out.println("Sum of all values: " + sumOfValues);
        System.out.println("Number of even products: " + evenCount);
        System.out.println("Number of odd products: " + oddCount);

        sc.close();
   // Fix so the program has proper rows and columns on the challenge part of the instructions
  }
}
