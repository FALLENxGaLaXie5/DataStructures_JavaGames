/**
 * Created by Joshua on 9/21/2015.
 *
 */
import java.util.Scanner;
public class EmailStrings
{
    public static void main(String[] args)
    {
        Scanner terminalInput = new Scanner(System.in);
        System.out.println("Enter String: ");
        String string = terminalInput.next();
        for (int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) == ' ')
            {
                string = string.replace(string.charAt(i), ' ');
            }
        }
        string = string.replaceAll(" ", "");

        System.out.println(string);
    }


}
