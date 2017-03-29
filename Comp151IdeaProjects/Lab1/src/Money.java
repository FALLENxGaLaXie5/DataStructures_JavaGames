/**
 * Created by joshua.steward095 on 1/22/2015.
 */
import java.util.Random;
public abstract class Money
{
    public int denomination;
    public boolean heads;



    public int getDenomination()
    {
        return this.denomination;
    }

    public abstract double getValue();

    public void toss()
    {
        this.heads = new Random().nextBoolean();
    }

    public boolean isHeads()
    {
        if (this.heads)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public abstract String toString();
}
