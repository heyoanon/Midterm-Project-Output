import java.util.Scanner;

public class NumberReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int snum, limit;
        int prime = 0, composite = 0;
        int odd = 0, even = 0;
        int palindrome = 0, armstrong = 0;
        int perfect = 0, abundant = 0, deficient = 0;
        
        int largestPrime = -1;
        int largestArmstrong = -1;
        int largestPerfect = -1;

        System.out.print("Enter a start number: ");
        snum = sc.nextInt();

        System.out.print("Enter an end number: ");
        limit = sc.nextInt();

//The following conditions and steps to count how many there are prime and composite numbers, and get the highest prime number in the given range.
        for (int i = snum; i <= limit; i++) {
            if (prime(i)) {
                prime++;
                if (i > largestPrime) {
                    largestPrime = i;
                }
            } else if (i > 1) {
                composite++;
            }

            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            
            //The following conditions and steps to count how many there are perfect, abundant, and deficient numbers in the range.
            if (i >= 0 && palindrome(i)) {
                palindrome++;
            }

            if (i >= 0 && armstrong(i)) {
                armstrong++;
                if (i > largestArmstrong) {
                    largestArmstrong = i;
                }
            }
            
            //The following conditions and steps to get the highest number of perfect, abundant, and deficient numbers in the range.
            if (i > 0) {
                int sum = sumOfProperDivisors(i);

                if (sum == i) {
                    perfect++;
                    if (i > largestPerfect) {
                        largestPerfect = i;
                    }
                } else if (sum > i) {
                    abundant++;
                } else {
                    deficient++;
                }
            }
        }
        
        System.out.println("\n====Number Analysis Report====");
        System.out.println();
        System.out.println("Range: " + snum + "-" + limit);
        System.out.println();
        System.out.println("Prime Numbers: " + prime);
        System.out.println("Composite Numbers: " + composite);
        System.out.println("Even Numbers: " + even);
        System.out.println("Odd Numbers: " + odd);
        System.out.println();
        System.out.println("Palindrome: " + palindrome);
        System.out.println("Armstrong: " + armstrong);
        System.out.println("Perfect: " + perfect);
        System.out.println("Abundant: " + abundant);
        System.out.println("Deficient: " + deficient);
        System.out.println();
        System.out.println("Largest Prime Number: " + largestPrime);
        System.out.println("Largest Armstrong Number: " + largestArmstrong);
        System.out.println("Largest Perfect Number: " + largestPerfect);

        sc.close();
    }

    //To check whether the number is truly prime or composite.
    private static boolean prime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
    
    //To check whether the number is truly a palindrome or not.
    public static boolean palindrome(int n) {
        int temp = n;
        int reversed = 0;

        while (temp > 0) {
            reversed = (reversed * 10) + (temp % 10);
            temp /= 10;
        }

        return n == reversed;
    }

    //To check whether the number is 
    public static boolean armstrong(int n) {
        if (n == 0) {
            return true;
        }

        int temp = n;
        int digits = 0;
        int sum = 0;

        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = n;

        while (temp > 0) {
            int remainder = temp % 10;
            sum += Math.pow(remainder, digits);
            temp /= 10;
        }

        return n == sum;
    }

    public static int sumOfProperDivisors(int n) {
        if (n == 1) {
            return 0;
        }

        int sum = 1;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;

                if (i != n / i) {
                    sum += n / i;
                }
            }
        }

        return sum;
    }
}