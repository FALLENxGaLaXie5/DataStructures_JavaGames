/* SavingsAcount
    Joshua Steward
*/

import java.text.DecimalFormat;
   // 1. ***** indicate that SavingsAccount inherits
   //          from BankAccount
public class SavingsAccount extends BankAccount
{
   public final DecimalFormat PERCENT_FORMAT
            = new DecimalFormat( "###0%" );
   public final double DEFAULT_RATE = .03;
   // 2. ****** define the private interestRate instance variable
   // interestRate, a double, represents an annual rate
   private double interestRate;
   
   // 3 ***** write the default constructor
   /** default constructor
   *   explicitly calls the BankAccount default constructor
   *   set interestRate to default value DEFAULT_RATE
   *   print a message to System.out indicating that
   *    constructor is called
   */
   public SavingsAccount()
   {
       super();
       this.interestRate = DEFAULT_RATE;
       System.out.println("Constructor is called.");
   }
   
   
   // 4 ***** write the overloaded constructor
   /** overloaded constructor
   *   explicitly call BankAccount overloaded constructor
   *   call setInterestRate method, passing startInterestRate
   *   print a message to System.out indicating that
   *    constructor is called
   *  @param  startBalance      starting balance
   *  @param  startInterestRate starting interest rate
   */
   public SavingsAccount(double startBalance, double startInterestRate)
   {
       super(startBalance);
       setInterestRate(startInterestRate);
       System.out.println("Overloaded Constructor called.");
   }



   // 5 ****** write the accessor method:
   /** accessor method for interestRate
   *  @return  interestRate
   */
   public double getInterestRate()
   {
       return this.interestRate;
   }
   
   
   
   // 6 ****** write the mutator method:
   /** mutator method for interestRate
   *  @param  newInterestRate new value for interestRate
   *          newInterestRate must be >= 0.0
   *            if not, print an error message
   */
   public void setInterestRate(double newInterestRate)
   {
       if (!(newInterestRate >= 0.0))
       {
           System.err.println("Interest rate must be positive.");
       }
       else
       {
           this.interestRate = newInterestRate;
       }
   }
   
   
   // 7 ****** write this business method:
   /** applyInterest method, no parameters, void return value
   *  call deposit method, passing a month's worth of interest
   *  remember that interestRate instance variable is annual rate
   */
   public void applyInterest()
   {
       deposit( (getBalance()* getInterestRate()) /12);
   }

   // 8 *****  write this method
   /* toString method
   *  @return String containing formatted balance and interestRate
   *    invokes superclass toString to format balance
   *    formats interestRate as percent using a DecimalFormat object 
   */

    public String toString()
    {
        return super.toString() + "\ninterest rate is " + PERCENT_FORMAT.format(this.interestRate);
    }
}
