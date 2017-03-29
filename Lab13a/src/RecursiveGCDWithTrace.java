/* Computing the greatest common divisor using recursion
   Anderson, Franceschi
*/
public class RecursiveGCDWithTrace
{
  public static void main( String [] args )
  {
    // compute gcd of 123450 and 60378 and output it
    System.out.println( "\nThe GCD of " + 123450 + " and "
                         + 60378 + " is " + gcd( 123450, 60378 ) );
  }
  /** recursive gcd method with trace
  *   @param    dividend   the first strictly positive integer
  *   @param    divisor    the second strictly positive integer
  *   @return              the gcd of dividend and divisor
  */
  public static int gcd( int dividend, int divisor )
  {
    System.out.print( "gcd( " + dividend + ", " + divisor + " )" );
    System.out.println( "   " + dividend + " % " + divisor + " = "
                         + ( dividend % divisor ) );
    if ( dividend % divisor == 0 )  // base case
    {
      System.out.println( "\nbase case reached, returning "
                           + divisor + "\n");
      return divisor;
    }
    else                           // general case
    {
      return gcd( divisor, dividend % divisor );
    }
  }
}
