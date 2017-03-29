import java.text.DecimalFormat;

/**
 * Created by Joshua Steward on 11/19/2014.
 */
public class GroceryStore extends Store
{
    private double annualRevenues;
    private boolean chain;

    public GroceryStore(String newName, double newAnnualRevenues, boolean newChain)
    {
        super(newName);
        setAnnualRevenues(newAnnualRevenues);
        setChain(newChain);

    }

    public double getAnnualRevenues()
    {
        return this.annualRevenues;
    }

    public void setAnnualRevenues(double newAnnualRevenues)
    {
        this.annualRevenues = newAnnualRevenues;
    }

    public boolean getChain()
    {
        return this.chain;
    }

    public void setChain(boolean newChain)
    {
        this.chain = newChain;
    }

    public boolean equals(GroceryStore o)
    {
        boolean returns = false;
        if (! ( o instanceof GroceryStore))
        {
            returns = false;
        }

        else
        {
            GroceryStore objGroceryStore = (GroceryStore) o;
            if (super.equals(o)
                    && (this.getAnnualRevenues() == objGroceryStore.getAnnualRevenues())
                    && this.getChain() == objGroceryStore.getChain())
            {
                returns = true;
            }
        }
    return returns;
    }

    public String toString ()
    {
        return super.toString() + "\nannual revenue: "
                + getAnnualRevenues() + "\nchain: " + getChain();
    }

    public double annualTaxes()
    {
        DecimalFormat pricePattern = new DecimalFormat("$##0.00");
        double taxes = this.annualRevenues * SALES_TAX_RATE;
        return taxes;
    }
}
