import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //The overall parameters set in the code.
        int pin, cpin, npin, choice;
        int limitatmps, tries, maxWithdraw;
        double balance, deposit, withdraw;
        double dailyWithdraw = 0;
        
        /**This is where the limitations has been set from. 
        *The fix/starting pin. You can change the pin when you select the change the pin option.
        */
        pin = 330618;
        //Initial Balance
        balance = 13000.62;
        //The Daily Withdrawal Limit
        double dailyLimit = 20000; 
        //Maximum Pin Attemps
        limitatmps = 3; 
        //The maximum attemps that you can withdraw.
        maxWithdraw = 5; 

        /**
        * State variables to track account security status and withdrawal count.
        */
        boolean unlocked = false; 
        int withdrawAttempts = 0;

        tries = 0;
        unlocked = false;
        
        // Initial PIN verification loop to unlock the ATM
        while (tries < limitatmps) {
            System.out.print("Enter your PIN: ");
            cpin = sc.nextInt();
            tries++;
            
            if (cpin == pin) {
                unlocked = true;
                break;
            } else {
                int remaining = limitatmps - tries;
                System.out.println("Wrong PIN. Attempts left: " + remaining);
            }
        }

        // Lock access if PIN entries exceed allowed attempts
        if (!unlocked) {
            System.out.println("Card is blocked. Please try again tomorrow.");
            sc.close();
            return;
        }

        // Main ATM menu loop
        do {
            System.out.println("1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");
            System.out.println("5. Transactional History");
            System.out.println("6. Exit");
            System.out.print("Enter a choice: ");
            choice = sc.nextInt();

      //The code in loop menu to run the following options.

            }
                     
        } while (choice != 6);
                  
        sc.close();
    }
}
