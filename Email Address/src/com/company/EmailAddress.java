//EmailAddress
//Joshua Steward
import java.util.Scanner;
public class EmailAddress
{
    public static void main( String [] args )
    {
        System.out.print("Enter email address: ");
        Scanner scan = new Scanner( System.in );
        String email = scan.nextLine();
        String ret = "";
        int symbol = email.indexOf('@');

        if (symbol < 0)
        {
            ret = "This is not an email address!";
        }
        else
        {
            ret = "This is an email address!";
        }
        System.out.println(ret);
    }
}