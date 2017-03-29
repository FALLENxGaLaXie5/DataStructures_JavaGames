/**
 * 6.14.3 # 22
 * Created by Joshua on 10/1/2014.
 */
import java.util.Scanner;

public class IntegerInput
{
    public static void main( String [] args )
    {

        Scanner scan = new Scanner( System.in );

        System.out.print("Enter a starting integer > ");
        int start = scan.nextInt();
        int number = start;
        while (number != 20)
        {
            System.out.print("Enter another integer > ");
            number = scan.nextInt();
            if (number >= start && number != 20)
            {
                System.out.println(number);
            }
        }
    }
}
