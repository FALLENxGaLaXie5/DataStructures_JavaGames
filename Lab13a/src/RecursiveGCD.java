/* Computing the greatest common divisor using recursion
   Anderson, Franceschi
*/

public class RecursiveGCD
{
  public static void main( String [] args )
  {
    // compute and output gcd of 123450 and 60378
    System.out.println( "The GCD of " + 123450 + " and "
                         + 60378 + " is " + gcd( 123450, 60378 ) );
  }

  /** recursive gcd method
  *   @param    dividend  the first strictly positive integer
  *   @param   divisor   the second strictly positive integer
  *   @return             the gcd of dividend and divisor
  */
  public static int gcd( int dividend, int divisor )
  {
    if ( dividend % divisor == 0 )  // base case
      return divisor;
    else            // general case
      return ( gcd ( divisor, dividend % divisor ) );
  }
}
