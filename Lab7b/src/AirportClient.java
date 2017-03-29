/* A client program to display Airport object values
 Joshua Steward
 */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class AirportClient extends JFrame
{
  String action1, action2;
  boolean firstTime = true;
  
  int animationPause = 6;     // 6 seconds between animations
  Airport airport1, airport2;  // declare Airport object references
  
  public void workWithAirports( )
  {
    animate( "Two airport object references declared:",
            "Airport airport1, airport2;" );
    
    /* Instantiate airport1 using the overloaded constructor  */
    airport1 = new Airport( "IAD", 30 );
    animate( "Instantiated airport1 using overloaded constructor:",
            "airport1 = new Airport( \"IAD\", 30 );" );
    
    /* Call toString( ) */
    animate( "Calling toString:",
            "System.out.println(\"The airport1 is: \" + airport1.toString());" );
    System.out.println("The airport1 is: " + airport1.toString());
    
    /*  Instantiate a second airport object using overloaded constructor*/
    airport2 = new Airport( "IAD", 30 );
    animate( "Instantiated airport2 using overloaded constructor:",
            "airport2 = new Airport( \"IAD\", 30 );" );
    
        /* Call toString( ) */
    animate( "Calling toString:",
            "System.out.println(\"The airport2 is \" + airport2);" );
    System.out.println("The airport2 is: " + airport2);
    
    /* Get the value of countAirports */
    animate( "Getting the value of countAirports:",
            "System.out.println(\"countAirports is \" + Airport.getCountAirports());" );
    System.out.println("countAirports is " + Airport.getCountAirports());
    
    /* Compare the two airport objects */
    animate( "Comparing airport1 and airport2 using == operator ",
            " if ( airport1 ==  airport2 )..." );
    System.out.print("Result of comparing airport1 and airport2 with == operator is: ");
    if ( airport1 ==  airport2 )
      System.out.println( "airport1 and airport2 are equal" );
    else
      System.out.println( "airport1 and airport2 are not equal" );
    
    /* Compare the two Airport objects */
    animate( "Comparing airport1 and airport2 using equals:",
            " if ( airport1.equals( airport2 ) )..." );
    System.out.print("Result of comparing airport1 and airport2 with equals method is: ");
    if ( airport1.equals( airport2 ) )
      System.out.println( "airport1 and airport2 are equal" );
    else
      System.out.println( "airport1 and airport2 are not equal" );
    
    /* Finished */
    animate( "Actions are complete, exiting", "" );
    System.exit( 1 );
  }
  
  public AirportClient( )
  {
    super( "Using the Airport Class" );
    setSize( 520, 400 );
    setVisible( true );
  }
  
  public void paint( Graphics g )
  {
    super.paint( g );
    if ( firstTime )
      firstTime = false;
    else
    {
      int boxL = 75, boxH = 20;
      int sX = 50, sY = 50;
      
      // countAirports
      g.setColor( Color.BLACK );
      g.drawRect( sX, sY, boxL, boxH );
      g.drawString( "countAirports", sX, sY - 10 );
      g.setColor( Color.BLUE );
      g.drawString( Integer.toString( Airport.getCountAirports( ) ),
                   sX + 15, sY + 15 );
      
      // airport1
      sY = 125;
      if ( airport1 != null )
      {
        // object reference box
        g.setColor( Color.BLACK );
        g.drawRect( sX, sY, boxL, boxH );
        g.drawString( "airport1", sX, sY - 10 );
        draw( g, sX, sY, airport1 ); // draw airport object
      }
      else
      {
        // indicate null reference
        g.setColor( Color.BLACK );
        g.drawRect( sX, sY, boxL, boxH );
        g.drawString( "airport1", sX, sY - 10 );
        g.setColor( Color.BLUE );
        g.drawString( "null", sX + 15, sY + 15 );
      }
      
      sY = 250;
      if ( airport2 != null )
      {
        // object reference box
        g.setColor( Color.BLACK );
        g.drawRect( sX, sY, boxL, boxH );
        g.drawString( "airport2", sX, sY - 10 );
        draw( g, sX, sY, airport2 ); // draw airport object
      }
      else
      {
        // indicate null reference
        g.setColor( Color.BLACK );
        g.drawRect( sX, sY, boxL, boxH );
        g.drawString( "airport2", sX, sY - 10 );
        g.setColor( Color.BLUE );
        g.drawString( "null", sX + 15, sY + 15 );
      }
      
      // display action at bottom of screen
      g.setColor( Color.BLUE );
      g.drawString( action1, 15, 370 );
      g.drawString( action2, 20, 385 );
    }
  }
  
  private void draw( Graphics g, int sX, int sY, Airport a )
  {
    int boxL = 75, boxH = 20;
    
    // arrow
    g.setColor( Color.BLACK );
    g.drawLine( sX + boxL, sY + boxH / 2,
               sX + boxL + 25, sY + boxH / 2 );
    g.drawLine( sX + boxL + 25, sY + boxH / 2,
               sX + boxL + 25, sY + boxH * 2 );
    g.drawLine( sX + boxL + 25 - 5, sY + boxH * 2 - 5,
               sX + boxL + 25, sY + boxH * 2 );
    g.drawLine( sX + boxL + 25 + 5, sY + boxH * 2 - 5,
               sX + boxL + 25, sY + boxH * 2 );
    
    // airportCode
    g.setColor( Color.BLACK );
    g.drawString( "airport code", sX + boxL - 75, sY + 2 * boxH + 15 );
    g.drawRect( sX + boxL, sY + 2 * boxH, boxL, boxH );
    g.setColor( Color.BLUE );
    g.drawString( a.getAirportCode( ),
                 sX + boxL + 5, sY + 2 * boxH + 15 );
    
    // gates
    g.setColor( Color.BLACK );
    g.drawString( "gates", sX + boxL - 75, sY + 3 * boxH + 15 );
    g.drawRect( sX + boxL, sY + 3 * boxH, boxL, boxH );
    g.setColor( Color.BLUE );
    g.drawString( Integer.toString( a.getGates( ) ),
                 sX + boxL + 5, sY + 3 * boxH + 15 );
  }
  
  private void animate( String a1, String a2 )
  {
    action1 = a1;
    action2 = a2;
    repaint( );
    Pause.wait( (double) animationPause );
  }
  
  public static void main( String [] args )
  {
    AirportClient app = new AirportClient( );
    app.workWithAirports( );
    app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}
