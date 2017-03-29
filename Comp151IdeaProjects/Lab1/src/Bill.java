import java.util.Random;

/**
 * Created by joshua.steward095 on 1/22/2015.
 */
import java.util.Random;
public class Bill extends Money
{
    private final int[] DENOMINATION_VALUE = {1, 2, 5, 10, 20, 50, 100};
    private final String[] DENOMINATION_NAME
            = {"WASHINGTON", "JEFFERSON", "LINCOLN", "HAMILTON", "JACKSON", "GRANT", "FRANKLIN"};
    private static final int NUMBER_OF_DENOMINATIONS = 7;

    public Bill()
    {
        Random random = new Random();
        denomination = random.nextInt(this.NUMBER_OF_DENOMINATIONS);
        heads = false;

    }

    public double getValue()
    {
        int denominationIndexValue = getDenomination();
        double value = (double)DENOMINATION_VALUE[denominationIndexValue];
        return value;
    }

    public String toString()
    {
        return this.DENOMINATION_NAME[getDenomination()];
    }
}
