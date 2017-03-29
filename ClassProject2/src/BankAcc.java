/**
 * Bank Account
 * Created by joshua.steward095 on 9/24/2014.
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class BankAcc
{
    public static void main( String [] args )
    {
        Scanner scan = new Scanner( System.in );
        System.out.print("Enter account number: ");
        int accNum = scan.nextInt();
        System.out.print("Enter account type: ");
        String accType = scan.next();
        System.out.print("Enter minimum balance: ");
        double minBalance = scan.nextDouble();
        System.out.print("Enter current balance: ");
        double currBalance = scan.nextDouble();
        DecimalFormat pricePattern = new DecimalFormat( "$#0.00" );

        final double serviceChargeS = 10;
        final double serviceChargeC = 25;




        if (!(accType.equalsIgnoreCase("S")) && !(accType.equalsIgnoreCase("C")))
        {
            System.out.println("Invalid Account Type: " + accType);
        }
        else
        {
            switch (accType)
            {
                case "S":
                case "s":
                    accType = "SAVINGS";
                    if (currBalance < minBalance)
                    {
                        System.out.println("The current balance is below the minimum, service charge of "
                                + pricePattern.format(serviceChargeS) + " is applied.");
                        double endBalance = currBalance - serviceChargeS;
                        System.out.println("Account numer: " + accNum);
                        System.out.println("Account type: " + accType);
                        System.out.println("Minimum balance: " + pricePattern.format(minBalance));
                        System.out.println("Starting balance: " + pricePattern.format(currBalance));
                        System.out.println("End balance: " + pricePattern.format(endBalance));
                    }
                    else
                    {
                        double endBalance = (currBalance * 0.04) + currBalance;
                        System.out.println("Account numer: " + accNum);
                        System.out.println("Account type: " + accType);
                        System.out.println("Minimum balance: " + pricePattern.format(minBalance));
                        System.out.println("Starting balance: " + pricePattern.format(currBalance));
                        System.out.println("End balance: " + pricePattern.format(endBalance));
                    }


                    break;

                case "C":
                case "c":
                    accType = "CHECKING";
                    if (currBalance < minBalance)
                    {
                        System.out.println("The current balance is below the minimum, service charge of "
                                 + pricePattern.format(serviceChargeC) + " is applied.");
                        double endBalance = currBalance - serviceChargeC;
                        System.out.println("Account numer: " + accNum);
                        System.out.println("Account type: " + accType);
                        System.out.println("Minimum balance: " + pricePattern.format(minBalance));
                        System.out.println("Starting balance: " + pricePattern.format(currBalance));
                        System.out.println("End balance: " + pricePattern.format(endBalance));
                    }
                    else if (currBalance <= minBalance + 5000)
                    {
                        double endBalance = (currBalance * 0.03) + currBalance;
                        System.out.println("Account numer: " + accNum);
                        System.out.println("Account type: " + accType);
                        System.out.println("Minimum balance: " + pricePattern.format(minBalance));
                        System.out.println("Starting balance: " + pricePattern.format(currBalance));
                        System.out.println("End balance: " + pricePattern.format(endBalance));
                    }
                    else
                    {
                        double endBalance = (currBalance * 0.05) + currBalance;
                        System.out.println("Account numer: " + accNum);
                        System.out.println("Account type: " + accType);
                        System.out.println("Minimum balance: " + pricePattern.format(minBalance));
                        System.out.println("Starting balance: " + pricePattern.format(currBalance));
                        System.out.println("End balance: " + pricePattern.format(endBalance));
                    }


                    break;

            }

        }

    }
}
