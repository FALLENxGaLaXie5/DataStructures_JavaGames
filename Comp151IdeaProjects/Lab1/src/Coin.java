/**
 * Created by joshua.steward095 on 1/22/2015.
 */
import java.util.Random;
public class Coin extends Money
{
    private final int[] DENOMINATION_VALUE = {1, 5, 10, 25, 50};
    private final String[] DENOMINATION_NAME = {"PENNY", "NICKEL", "DIME", "QUARTER", "HALF_DOLLAR"};
    private static final int NUMBER_OF_DENOMINATIONS = 5;

    public Coin()
    {
        Random random = new Random();
        denomination = random.nextInt(this.NUMBER_OF_DENOMINATIONS);
        heads = false;
    }



    public double getValue()
    {
        int denominationIndexValue = getDenomination();
        double value = (double)DENOMINATION_VALUE[denominationIndexValue]/100.0;
        return value;
    }

    public String toString()
    {
        return this.DENOMINATION_NAME[getDenomination()];
    }
}
