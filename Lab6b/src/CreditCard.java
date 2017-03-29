/**
 *Credit Card Number Calculator
 * Created by joshua.steward095 on 10/1/2014.
 * Joshua Steward
 */
import java.util.*;

public class CreditCard
{
    public static void main( String [] args)
    {
        Scanner scan = new Scanner( System.in );
        String answer = "";
        final String CARD_PATTERN = "[0-9]{8}";
        do
        {
            String creditCard = "";
            int l = 0;
            int total = 0;

            do
            {
                System.out.print("Enter 8-digit credit card number: ");
                creditCard = scan.nextLine();
            }while (!(creditCard.matches(CARD_PATTERN)));

            for (l = creditCard.length() - 1; l >= 0; l--)
            {
                char creditChar = creditCard.charAt(l);
                int creditInt = Character.digit(creditChar, 10);

                if (l % 2 == 1)
                {
                    total = total + creditInt;
                }

                else
                {
                    creditInt = creditInt * 2;
                    int firstDigit = creditInt/10;
                    int lastDigit = creditInt % 10;

                    total = total + firstDigit + lastDigit;

                }


            }

            if (total % 10 == 0)
            {
                System.out.println("The credit card number " + creditCard + " is valid!");
            }
            else
            {
                System.out.println("The credit card number " + "\"" + creditCard + "\"" + " is NOT valid!");

            }
            System.out.println("The checksum is " + total);
            System.out.print("Would you like to convert another card? (yes/no)");
            answer = scan.next();

        }while (answer.equals("yes"));
        System.out.println("Bye!");
    }
}
