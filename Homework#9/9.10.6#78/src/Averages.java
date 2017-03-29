/**
 * Created by Joshua Steward on 11/9/2014.
 */
public class Averages
{
    public Averages()
    {

    }
    public double AverageOfElements(int[][] ham)
    {
        int sum = 0;
        int count = 0;
        for (int r = 0; r < ham.length; r++)
        {
            for (int c = 0; c < ham[r].length; c++)
            {
                count++;
                sum += ham[r][c];
            }
        }
        return (double)sum/(double)count;
    }
}
