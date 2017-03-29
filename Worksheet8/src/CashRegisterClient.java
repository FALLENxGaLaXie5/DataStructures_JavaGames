/**
 * Created by Joshua on 10/10/2014.
 */
public class CashRegisterClient
{
    public static void main( String [] args)
    {
        CashRegister register=new CashRegister();
        register.recordPurchase(29.50);
        register.recordPurchase(9.25);
        register.enterPayment(50);
        register.recordTaxablePurchase(10);
        System.out.print("Your purchase amount is "+ register.getPurchase());
        System.out.print(" Your payment amount is "+ register.getPayment());
        System.out.print(" Your change amount is "+ register.giveChange());
        System.out.print("The number of purchases made is " + register.getItemCount());
    }
}
