/**
 * Created by Joshua on 9/26/2014.
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class TaxableIncome
{
    public static void main( String [] args )
    {
        Scanner scan = new Scanner( System.in );
        System.out.print("Enter income here: ");
        double income = scan.nextDouble();
        System.out.print("Enter marital status (single or married) here: ");
        String status = scan.next();
        DecimalFormat pricePattern = new DecimalFormat( "$#0.00" );
        double sIncome = 0;

        if (status.equalsIgnoreCase("single"))
        {
            if ((income > 0)&& (income < 8000))
            {
                sIncome = (.1 * income);

            }
            else if ((income > 8000)&&(income < 32000))
            {
                sIncome = 800 + (.15 * (income - 8000));
            }
            else if (income > 32000)
            {
                sIncome = 4400 + (.25 * (income - 32000));
            }
        }
        else if (status.equalsIgnoreCase("married"))
        {
            if ((income > 0)&&(income < 16000))
            {
                sIncome = (.1 * income);
            }
            else if ((income > 16000) && (income < 64000))
            {
                sIncome = 1600 + (.15 * (income - 16000));
            }
            else if (income > 64000)
            {
                sIncome = 8800 + (.25 * (income - 64000));
            }
        }

        System.out.println("The subtracted income is " + pricePattern.format(sIncome));
    }
}
