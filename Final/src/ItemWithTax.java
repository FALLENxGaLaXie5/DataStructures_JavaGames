import java.text.DecimalFormat;

/**
 * Created by Joshua Steward on 12/6/2014.
 */
public class ItemWithTax extends Item
{
    private final double SALES_TAX = 0.07;
    private final DecimalFormat percentPattern = new DecimalFormat("#0.0%");

    public ItemWithTax(String name, double price, int inventory)
    {
        super(name, price, inventory);
    }

    public double calculateCost()
    {
        this.setPrice(this.getPrice() * SALES_TAX);
        return this.getPrice();
    }

    public String toString()
    {
        return this.getName() + "@ " + this.getPrice()
                + " plus sales tax of " + percentPattern.format(SALES_TAX)
                + " (inventory of " + this.getNumberOfItems() + ")";
    }
}
