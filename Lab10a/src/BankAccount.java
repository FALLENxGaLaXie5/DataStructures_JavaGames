/**   BankAccount class, version 1
*     Anderson, Franceschi
*     Represents a generic bank account
*/
import java.text.DecimalFormat;

public class BankAccount
{
  public final DecimalFormat MONEY
                  = new DecimalFormat( "$#,##0.00" );
  private double balance;

  /** Default constructor
  *   sets balance to 0.0
  */
  public BankAccount( )
  {
    balance = 0.0;
    System.out.println( "In BankAccount default constructor" );
  }

  /** Overloaded constructor
  *   @param startBalance  beginning balance
  */
  public BankAccount( double startBalance )
  {
    deposit( startBalance );
    System.out.println( "In BankAccount overloaded constructor" );
  }

  /** Accessor for balance
  *   @return  current account balance
  */
  public double getBalance( )
  {
    return balance;
  }

  /** Deposit amount to account
  *   @param amount  amount to deposit;
  *                  amount must be >= 0.0
  */
  public void deposit( double amount )
  {
    if ( amount >= 0.0 )
      balance += amount;
    else
      System.err.println( "Deposit amount must be positive." );
  }

  /** withdraw amount from account
  *    @param amount   amount to withdraw;
  *                    amount must be >= 0.0
  *                    amount must be <= balance
  */
  public void withdraw( double amount )
  {
    if (  amount >= 0.0 && amount <= balance )
      balance -= amount;
    else
      System.err.println( "Withdrawal amount must be positive "
                          + "and cannot be greater than balance" );
  }

  /** toString
  *  @return  the balance formatted as money
  */
  public String toString( )
  {
    return ( "balance is " + MONEY.format( balance ) );
  }
}
