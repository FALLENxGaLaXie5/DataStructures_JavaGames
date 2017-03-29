/**
 * Joshua Steward
 * Date: 12/15/14
 */
public class CashRegister
{
    private double cashOnHand;
    private final double INITIAL_CASH = 50;


    public CashRegister()
    {
        this.cashOnHand = INITIAL_CASH;
    }

    public double getCashOnHand()
    {
        return this.cashOnHand;
    }

    public void addCash(double amountIn)
    {
        this.cashOnHand += amountIn;
    }
}