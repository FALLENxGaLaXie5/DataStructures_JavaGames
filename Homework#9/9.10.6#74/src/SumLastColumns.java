/**
 * Created by Joshua Steward on 11/9/2014.
 */
public class SumLastColumns
{
    public SumLastColumns()
    {

    }
    public int sumOf(int[][] ham)
    {
        int sum = 0;
        for (int r = 0; r < ham.length; r++)
        {
            for (int c = ham[r].length - 1; c < ham[r].length; c++)
            {
                sum+= ham[r][c];
            }
        }
        return sum;
    }
}
