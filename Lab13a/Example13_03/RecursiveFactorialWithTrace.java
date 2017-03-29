/* Computing the factorial of a number using recursion
   Anderson, Franceschi
*/

public class RecursiveFactorialWithTrace
{
  public static void main( String [] args )
  {
    // compute factorial of 5 and output it
    System.out.println( "\nFactorial( 5 ) is "
                      + factorial( 5 ) );
  }

  /** recursive factorial method
  *   @param   n  a positive integer
  *   @return   the factorial of n
  */
  public static int factorial( int n )
  {
    System.out.println( "factorial( " + n + " ) called" );
    if ( n == 0)  // base case
    {
      System.out.println( "\nBase case detected" );
      System.out.println( "factorial( " + n + " ) returning 1\n" );
      return 1;
    }
    else        // general case
    {
      return ( n * factorial( n - 1 ) );
    }
  }
}
