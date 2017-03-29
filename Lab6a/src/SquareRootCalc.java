
import java.util.Scanner;

/**
 * SquareRootCalculations
 * Created by joshua.steward095 on 9/29/2014.
 */
public class SquareRootCalc
{
    public static void main( String[] args )
    {
        int line = 0;
        double SENTINEL = 1.01;
        double number;
        Scanner scan = new Scanner( System.in );

        do
        {
            System.out.print("Enter value greater than 10: ");
            number = scan.nextDouble();

        }while (!(number > 10.0));

        double result = Math.sqrt(number);

        while (result > SENTINEL)
        {
            line = line + 1;

            System.out.println(line + ". Calculated square root is --> " + result);
            result = Math.sqrt(result);

        }
        System.out.println("For the input " + number
                + " the number of square roots greater or equal than " + SENTINEL
                + " is " + line + ".");

    }
}
