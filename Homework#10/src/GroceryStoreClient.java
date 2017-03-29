/* GroceryStoreClient class
 Anderson, Franceschi
 */

import java.text.DecimalFormat;

public class GroceryStoreClient
{
  public static void main( String [] args )
  {
    GroceryStore gs1 = new GroceryStore( "Eddie's", 3523450.45, false );
    GroceryStore gs2 = new GroceryStore( "Eddie's", 4321090.65, true );
    
    System.out.println( gs1 );
    System.out.println( gs2 );
    
    if ( gs1.equals( gs2 ) )
      System.out.println( "gs1 and gs2 are equal - INCORRECT" );
    else
      System.out.println( "gs1 and gs2 are not equal - CORRECT" );
    
    gs2.setName("Giant 43");
    if ( gs1.equals( gs2 ) )
      System.out.println( "gs1 and gs2 are equal - INCORRECT" );
    else
      System.out.println( "gs1 and gs2 are not equal - CORRECT" );
    
    gs2.setAnnualRevenues( 3523450.45 );
    gs2.setChain( false );  
    if ( gs1.equals( gs2 ) )
      System.out.println( "gs1 and gs2 are equal - INCORRECT" );
    else
      System.out.println( "gs1 and gs2 are not equal - CORRECT" );
    
    gs2.setName( "Eddie's" );    
    if ( gs1.equals( gs2 ) )
      System.out.println( "gs1 and gs2 are equal - CORRECT" );
    else
      System.out.println( "gs1 and gs2 are not equal - INCORRECT" );
    
    DecimalFormat pricePattern = new DecimalFormat( "$#,##0.00" );
    System.out.println( "Annual taxes for " + gs1.getName( )
                         + " calculated as SALES_TAX_RATE times annualRevenues are " + pricePattern.format( gs1.annualTaxes( ) ) );
  }
}