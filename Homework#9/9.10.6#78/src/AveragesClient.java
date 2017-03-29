/**
 * Created by Joshua Steward on 11/9/2014.
 */
public class AveragesClient
{
    public static void main(String [] args)
    {
        int[][] arrayOfHam = {{1,5,6},
                {3,2,1,1},
                {1,2,3},
                {1,4,6}};
        Averages firstAverage = new Averages();
        System.out.println("The average of the elements is " + firstAverage.AverageOfElements(arrayOfHam));
    }
}
