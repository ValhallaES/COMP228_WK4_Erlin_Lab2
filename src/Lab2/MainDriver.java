package Lab2;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainDriver {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Interest[] interestObjects = new Interest[5];

        System.out.println("--- Employee/Client Interest Calculator ---");
        System.out.println("Note: Principal and Rate MUST be entered as decimals (e.g., 1000.0).");

        for (int i = 0; i < 5; i++) {
            System.out.println("\n[ Creating Object " + (i + 1) + " of 5 ]");
            
            try {
                System.out.print("Enter Principal Amount (decimal required): ");
                String principalInput = scanner.nextLine();
                
                BigDecimal principal = new BigDecimal(principalInput);
                if (principal.compareTo(BigDecimal.ZERO) < 0) {
                    throw new IllegalArgumentException("Negative values are not permitted.");
                }
                if (!principalInput.contains(".")) {
                    throw new IllegalArgumentException("Integers are not permitted. You must use decimals.");
                }
                

                System.out.print("Enter Interest Rate (decimal required, e.g. 5.5 for 5.5%): ");
                String rateInput = scanner.nextLine();
                
                BigDecimal rate = new BigDecimal(rateInput); 
                if (rate.compareTo(BigDecimal.ZERO) < 0) {
                    throw new IllegalArgumentException("Negative values are not permitted.");
                }
                if (!rateInput.contains(".")) {
                    throw new IllegalArgumentException("Integers are not permitted. You must use decimals.");
                }

                System.out.print("Enter Time in years (integer): ");
                String timeInput = scanner.nextLine();
                
                int time = Integer.parseInt(timeInput);
                if (time < 0) {
                    throw new IllegalArgumentException("Negative values are not permitted.");
                }

                Interest currentInterest = new Interest(principal, rate, time);
                interestObjects[i] = currentInterest;
                
                BigDecimal simpleInt = currentInterest.calculateSimpleInterest(principal, rate, time);
                BigDecimal compInt = currentInterest.calculateCompoundInterest(principal, rate, time);
                
                System.out.println(" SUCCESS: Valid Data Entered.");
                System.out.println(" BigDecimal Simple Interest: $" + simpleInt);
                System.out.println(" BigDecimal Compound Interest: $" + compInt);
                
                double pDouble = currentInterest.getPrincipalDouble();
                double rDouble = currentInterest.getRateDouble();
                int timeVal = currentInterest.getTime();
                
                double simpleIntDouble = currentInterest.calculateSimpleInterest(pDouble, rDouble, timeVal);
                double compIntDouble = currentInterest.calculateCompoundInterest(pDouble, rDouble, timeVal);
                
                System.out.println(" Double Simple Interest: $" + simpleIntDouble);
                System.out.println(" Double Compound Interest: $" + compIntDouble);

            } catch (NumberFormatException e) {
                System.out.println(" Error: String/Text characters are not permitted.");
                System.out.println(" Please try again.");
                i--;
            } catch (IllegalArgumentException e) {
                System.out.println(" Error: " + e.getMessage());
                System.out.println(" Please try again.");
                i--;
            }
        }
        
        System.out.println("\nAll 5 objects successfully created and calculated. Program terminating.");
        scanner.close();
    }
}