/**
 * 6.14.3 # 24
 * Sum of the first 4 multiples of 7
 * Created by Joshua on 10/4/2014.
 */
public class SumMultiples7
{
    public static void main( String [] args )
    {
        int sum = 0;
        int countMultiplesOf7 = 0;
        int count = 1;

        while (count <= 4)
        {

            countMultiplesOf7 = countMultiplesOf7 + 7;
            count ++;
            sum = sum + countMultiplesOf7;
        }
        System.out.println("The sum of the first four multiples of 7 is equal to " + sum + ".");
    }
}
