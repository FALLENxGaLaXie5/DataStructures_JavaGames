/**
 * Created by atb on 12/6/2014.
 */
public class ItemNoTax extends Item
{
    public ItemNoTax(String name, double price, int inventory)
    {
        super(name, price, inventory);
    }

    public double calculateCost()
    {
        return this.getPrice();
    }

    public String toString()
    {
        return "@ " + this.getPrice() + " no sales tax (inventory of " + this.getNumberOfItems() + ")";
    }
}
