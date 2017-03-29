/**
 * Binary code matcher
 * Created by joshua.steward095 on 9/24/2014.
 */
import java.util.Scanner;
public class BinaryMatch
{
    public static void main( String [] args )
    {
        Scanner scan = new Scanner( System.in );
        System.out.print("Please enter a binary number: ");
        String num = scan.next();
        String VALID_BINARY_NUMBER = "[01]+";
        String ACCEPT_PATTERN = "[01]*(0000)+[01]*";

        if (num.matches(VALID_BINARY_NUMBER)&& num.matches(ACCEPT_PATTERN))
        {
            System.out.println("The entered binary number " + "\"" + num + "\"" + " is accepted.");
        }
        else if (num.matches(VALID_BINARY_NUMBER) && !(num.matches(ACCEPT_PATTERN)))
        {
            System.out.println("The entered binary number " + "\"" + num + "\"" + " is rejected.");
        }
        else
        {
            System.out.println("The entered input " + "\"" + num + "\"" + " is not a valid binary number.");
        }
    }
}
