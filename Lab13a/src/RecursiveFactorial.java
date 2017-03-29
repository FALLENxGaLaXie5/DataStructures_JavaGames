/* Computing the factorial of a number using recursion
   Anderson, Franceschi
*/

public class RecursiveFactorial
{
  public static void main( String [] args )
  {
    // compute factorial of 5 and output it
    System.out.println( "Factorial ( 5 ) is "
                      + factorial( 5 ) );
  }

  /** recursive factorial method
  *   @param   n  a positive integer
  *   @return      the factorial of n
  */
  public static int factorial( int n )
  {
    if ( n <= 0 )  // base case
     return 1;
    else    // general case
     return ( n * factorial ( n - 1 ) );
  }
}
