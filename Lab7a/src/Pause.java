/* Pause class
*  Anderson, Franceschi
*/

public class Pause
{
  /** wait method
  *  @param seconds  number of seconds to pause
  */
  public static void wait( double seconds )
  {
     try
     {
       Thread.sleep( (int)( seconds * 1000 ) );
     }
     catch ( InterruptedException e )
     {
       e.printStackTrace( );
     }
  }
}