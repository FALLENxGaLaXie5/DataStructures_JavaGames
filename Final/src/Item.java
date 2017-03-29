import java.security.InvalidParameterException;
import java.text.DecimalFormat;

/**
 * Created by Joshua Steward on 12/6/2014.
 */
public abstract class Item
{
    private String name;
    private double price;
    private int numberOfItems;

    public Item(String name, double price, int inventory)
    {
        this.name = name;
        this.price = price;
        this.numberOfItems = inventory;
    }

    public int getNumberOfItems()
    {
        return this.numberOfItems;
    }

    public void setNumberOfItems(int newNumberOfItems) throws InvalidParameterException
    {
        this.numberOfItems = newNumberOfItems;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(double newPrice) throws InvalidParameterException
    {
        this.price = newPrice;
    }

    public String getName()
    {
        return this.name;
    }

    public void decrementNumberOfItems()
    {
        this.numberOfItems --;
    }

    public String toString()
    {

        return "";
    }

    public abstract double calculateCost();
}
