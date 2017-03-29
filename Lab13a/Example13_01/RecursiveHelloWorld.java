 /* Printing Hello World n times using recursion
    Anderson, Franceschi
 */

 public class RecursiveHelloWorld
 {
   public static void main( String [] args )
   {
      // print "Hello World" 5 times using our recursive method
      printHelloWorldNTimes( 5 );
   }

   // the recursive method
   public static void printHelloWorldNTimes( int n )
   {
       if ( n > 0 )
     {
       // print "Hello World" once
       System.out.println( "Hello World" );

       // now print "Hello World" ( n - 1 ) times
       printHelloWorldNTimes( n - 1 );
     }
     // if n is 0 or less, do nothing
   }
 }
