/**
 * Created by Joshua Steward on 10/10/2014.
 */
public class CashRegister
{
    private double purchase;
    private double payment;
    private int count;
    private double tax;
    public CashRegister()
    {
        purchase = 0.0;
        payment = 0.0;
        count = 0;
        tax = 0.06;
    }

    public double getPurchase()
    {
        return purchase;
    }

    public double getPayment()
    {
        return payment;
    }

    public void recordPurchase(double amount)
    {
        purchase += amount;
        count ++;
    }

    public void enterPayment(double amount)
    {
        payment = amount;
    }

    public double giveChange()
    {
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        return change;

    }
    public int getItemCount()
    {
        return count;
    }

    public void recordTaxablePurchase(double amount)
    {
        purchase += amount+(amount*tax);
        count ++;
    }

}

