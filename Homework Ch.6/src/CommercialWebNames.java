/**
 * Commercial Web Address Scanner
 * Created by Joshua Steward on 10/4/2014.
 */
import java.util.Scanner;

public class CommercialWebNames
{
    public static void main( String [] args )
    {
        Scanner scan = new Scanner( System.in );

        String stopTest = "";
        int count = 0;

        do
        {
            System.out.print("Enter a website name or " + "\"" + "stop" + "\"" + ": ");
            stopTest = scan.nextLine();
            String comTest = stopTest.substring(stopTest.lastIndexOf(".") + 1, stopTest.length());
            if (comTest.equals("com"))
            {
                count ++;
            }
        }while (!(stopTest.equals("stop")));
        System.out.println("You inputted " + count + " commercial websites.");
    }
}
