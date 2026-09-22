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
            }

        //The code in menu loop to run the following options.
        switch (choice) {
                // Case 1: Check current balance
                case 1:
                    System.out.printf("\nCurrent Balance: %.2f%n", balance);
                    System.out.println("\n");
                    break;
            
                // Case 2: Deposit money into the account
                case 2:
                    System.out.print("\nEnter the deposit amount: ");
                    deposit = sc.nextDouble();
            
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.printf("Deposited amount: %.2f%n", deposit);
                        System.out.printf("New balance: %.2f%n", balance);
                        System.out.println("\n");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
            
                // Case 3: Withdraw money with attempt limit and balance validations
                case 3:
                    if (withdrawAttempts >= maxWithdraw) {
                        System.out.println("Your daily withdrawal attempts limit has been reached.");
                    } else {
                        System.out.print("Enter withdrawal amount: ");
                        withdraw = sc.nextDouble();
               
                        if (withdraw <= 0) {
                            System.out.println("Invalid withdrawal amount.");
                        } else if (dailyWithdraw + withdraw > dailyLimit) {
                            System.out.println("Your daily withdrawal limit has been reached.");
                            System.out.println("\n");
                        } else if (withdraw > balance) {
                            System.out.println("Insufficient balance.");
                            System.out.println("\n");
                        } else {
                            balance -= withdraw;
                            dailyWithdraw += withdraw;
                            withdrawAttempts++;
               
                            System.out.println("Withdrawal successful.");
                            System.out.printf("Withdrawn amount: %.2f%n", withdraw);
                            System.out.printf("Remaining balance: %.2f%n", balance);
                            System.out.println("\n");
                        }
                    }
                    break;
                            
                // Case 4: Update the ATM PIN
                case 4:
                    System.out.print("Enter your current PIN: ");
                    cpin = sc.nextInt();
            
                    if (cpin == pin) {
                        System.out.print("Enter your new PIN: ");
                        npin = sc.nextInt();
            
                        pin = npin;
                        System.out.println("Your PIN has been successfully changed.");
                        System.out.println("\n");
                    } else {
                        System.out.println("Incorrect current PIN.");
                        System.out.println("\n");
                    }
                    break;
            
                // Case 5: View summary of account transactions and attempt counts
                case 5:
                    System.out.println();
                    System.out.println("===== Transactional History =====");
                    System.out.printf("Current Balance: %.2f%n", balance);
                    System.out.printf("Total Withdrawn Today: %.2f%n", dailyWithdraw);
                    System.out.println("Withdrawal Attempts Today: " + withdrawAttempts);
                    System.out.println("\n");
                    break;
            
                // Case 6: Exit menu option
                case 6:
                    break;
            
                // Default message for invalid numeric choices
                default:
                    System.out.println("Invalid choice. Please enter a number in the choices.");
            }
                     
        } while (choice != 6);
                  
        sc.close();
    }
}
