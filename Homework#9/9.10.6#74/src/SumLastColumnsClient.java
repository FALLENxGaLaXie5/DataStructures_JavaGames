/**
 * Created by Joshua on 11/9/2014.
 */
public class SumLastColumnsClient
{
    public static void main( String [] args)
    {
        int [][] arrayOfHam = {{1, 3, 6, 9, 12},
                {5, 6, 9, 3},
                {3, 10, 11, 20, 3}};
        SumLastColumns sum = new SumLastColumns();
        System.out.println("The sum of the last columns is " + sum.sumOf(arrayOfHam));
    }
}
