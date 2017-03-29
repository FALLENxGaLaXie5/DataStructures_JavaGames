/**
 * User ID Validator
 * Created by Joshua on 10/5/2014.
 */
import java.util.Scanner;

public class UserID
{
    public static void main( String [] args)
    {
        Scanner scan = new Scanner( System.in );
        final String DIGIT_IDENTIFIER = "[0-9]";
        int i = 0;
        int digitCount = 0;
        String out = "";
        System.out.print("Please enter user ID: ");
        String userID = scan.nextLine();

        for(i = 0; i < userID.length(); i++)
        {
            char currentChar = userID.charAt(i);
            switch (currentChar)
            {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    digitCount ++;
                    break;
                default:
                    break;
            }
        }
        if (digitCount == 2)
        {
            out = "This user ID is valid.";
        }
        else
        {
            out = "This user ID has " + digitCount + " digit(s); it must have 2. User ID is invalid.";
        }

        System.out.println(out);
    }
}
