/* Teller class for exercising the SavingsAccount class
*  Anderson, Franceschi
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class Teller extends JFrame
{
  private JButton changeRate,
                  applyInterest,
                  deposit,
                  withdraw,
                  accountInfo,
                  exit;
  private JTextArea ledgerActivity, ledgerBalance, ledgerRate;
  private String lActivity, lBalance, lRate;
  private double rate, balance, amount;
  private NumberFormat currency, percent;
  private static SavingsAccount s1;
  private JPanel buttonPanel, ledgerPanel;

  public Teller( )
  {
    super( "Savings Account Ledger" );
    Container cp = getContentPane( );

    buttonPanel = new JPanel( );
    buttonPanel.setLayout( new FlowLayout( ) );

    changeRate = new JButton( "Change interest rate" );
    buttonPanel.add( changeRate );
    ButtonHandler bh = new ButtonHandler( );
    changeRate.addActionListener( bh );

    applyInterest = new JButton( "Apply interest" );
    buttonPanel.add( applyInterest );
    applyInterest.addActionListener( bh );

    deposit = new JButton( "Deposit" );
    buttonPanel.add( deposit );
    deposit.addActionListener( bh );

    withdraw = new JButton( "Withdraw" );
    buttonPanel.add( withdraw );
    withdraw.addActionListener( bh );

    accountInfo = new JButton( "Display Account Information" );
    buttonPanel.add( accountInfo );
    accountInfo.addActionListener( bh );

    exit = new JButton( "Exit" );
    buttonPanel.add( exit );
    exit.addActionListener(
      new ActionListener( )
      {
        public void actionPerformed( ActionEvent e )
        {
          System.exit( 0 );
        }
      }
    );

    ledgerPanel = new JPanel( );
    ledgerPanel.setLayout( new GridLayout( 1, 3 ) );

    ledgerActivity = new JTextArea( );
    lActivity = "ACTIVITY\n";
    lActivity += "Account Opened\n";
    ledgerActivity.setText( lActivity );
    ledgerActivity.setEditable( false );
    ledgerPanel.add( ledgerActivity );

    currency = NumberFormat.getCurrencyInstance( );
    ledgerBalance = new JTextArea( );
    lBalance = "BALANCE\n";
    lBalance += currency.format( s1.getBalance( ) ) + "\n";
    ledgerBalance.setText( lBalance );
    ledgerBalance.setEditable( false );
    ledgerPanel.add( ledgerBalance );

    percent = NumberFormat.getPercentInstance( );
    ledgerRate = new JTextArea( );
    lRate = "INTEREST RATE\n";
    lRate += percent.format( s1.getInterestRate( ) ) + "\n";
    ledgerRate.setText( lRate );
    ledgerRate.setEditable( false );
    ledgerPanel.add( ledgerRate );

    cp.setLayout( new GridLayout( 2, 1 ) );
    cp.add( buttonPanel );
    cp.add( ledgerPanel );

    setSize( 300, 350 );
    setVisible( true );
  }

  private class ButtonHandler implements ActionListener
  {
    public void actionPerformed( ActionEvent e )
    {
      if ( e.getSource( ) == accountInfo )
      {
         JOptionPane.showMessageDialog( null, s1, "Account Information",
                  JOptionPane.INFORMATION_MESSAGE );
      }
      else
      {
       if ( e.getSource( ) == changeRate )
       {
        rate = getInput( "new interest rate (Ex: .05 is 5%)" );
        s1.setInterestRate( rate );
        lActivity += "Rate changed\n";
       }
       else if ( e.getSource( ) == applyInterest )
       {
        s1.applyInterest( );
        lActivity += "Interest applied\n";
       }
       else if ( e.getSource( ) == deposit )
       {
        amount = getInput( "amount to deposit" );
        s1.deposit( amount );
        lActivity += "Deposit\n";
       }
       else if ( e.getSource( ) == withdraw )
       {
        amount = getInput( "amount to withdraw" );
        s1.withdraw( amount );
        lActivity += "Withdrawal\n";
       }

       lBalance += currency.format( s1.getBalance( ) ) + "\n";
       lRate += percent.format( s1.getInterestRate( ) ) + "\n";
       ledgerActivity.setText( lActivity );
       ledgerBalance.setText( lBalance );
       ledgerRate.setText( lRate );
       repaint( );
     }
   }
 }

 public double getInput( String inputItem )
 {
     double amount = 0.0;
     String input = "";
     boolean badInput = true;
     do
     {
        input = JOptionPane.showInputDialog( "Enter the " + inputItem );
        if ( input != null )
        {
        try
        {
            amount = Double.parseDouble( input );
            badInput = false;
        }
        catch ( NumberFormatException nfe )
        {
           badInput = true;
           JOptionPane.showMessageDialog( null, inputItem + " must be numeric",
                              "Input error", JOptionPane.ERROR_MESSAGE );
        }
      }
     }while ( badInput == true );
     return amount;
  }

  public static void main( String [] args )
  {
    double balance = 0.0, rate = 0.0;
    String input = "";

    boolean badBalance = true;
    boolean defaultObj = false;

    do
    {
       input =
         JOptionPane.showInputDialog( "Enter the starting balance;"
            + " or press return to use the default constructor" );

       if ( input == null )
       {
         System.exit( 0 );
       }
       else if ( input.length( ) == 0 )
       {
           s1 = new SavingsAccount( ); // use default constructor
           badBalance = false;
           defaultObj = true;
       }
       else
       {
        try
        {
          balance = Double.parseDouble( input );
          if ( balance < 0.0 )
           JOptionPane.showMessageDialog( null, "Balance cannot be negative" );
          else
           badBalance = false;
        }
        catch ( NumberFormatException e )
        {
         JOptionPane.showMessageDialog( null, "Balance must be a number" );
        }
       }
    }while ( badBalance );

    if ( ! defaultObj )
    {
      boolean badRate = true;
      do
      {
       try
       {
        input =
            JOptionPane.showInputDialog( "Enter the interest rate (for example .05 is 5%)" );
        if ( input != null )
        {
          rate = Double.parseDouble( input );
          if ( rate < 0.0 )
             JOptionPane.showMessageDialog( null, "Interest rate cannot be negative" );
          else
              badRate = false;
        }
        else
          System.exit( 0 );
        }
        catch ( NumberFormatException e )
        {
           JOptionPane.showMessageDialog( null, "Interest rate must be a number" );
        }
       }while ( badRate );
       s1 = new SavingsAccount( balance, rate );
     }

     Teller app = new Teller( );
     app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}