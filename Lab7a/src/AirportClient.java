/* A client program to display Airport object values
   Anderson, Franceschi
*/

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class AirportClient extends JFrame
{
  String action1, action2;
  boolean firstTime = true;

  double animationPause = 5.0;      // 5 seconds between animations
  Airport airport1, airport2;  // declare Airport object references

  public void workWithAirports( )
  {
    animate( "Two airport object references declared:",
                   "Airport airport1, airport2;" );

      /* Instantiate the airport using an empty argument list  */
    airport1 = new Airport( );
    animate( "Instantiated airport1 using default constructor:",
                    "airport1 = new Airport( );" );

    /* Set the airport code to IAD */
    airport1.setAirportCode( "IAD" );
    animate( "Set the airport1 code to IAD:",
                    "airport1.setAirportCode( \"IAD\" );" );

    /*  Set the number of gates to 30 */
    airport1.setGates( 30 );
    animate( "Set the number of gates to 30:" ,
                    "airport1.setGates( 30 );" );

    /*  Set the number of gates to -1, an invalid value */
    airport1.setGates( -1 );
    animate( "Attempted to set the number of gates to -1:",
                    "airport1.setGates( -1 );" );

    /*  Instantiate a second airport object using non-default constructor*/
    airport2 = new Airport( "JFK", 69 );
    animate( "Instantiated airport2 using overloaded constructor:",
                    "airport2 = new Airport( \"JFK\", 69 );" );

    /* Finished */
    animate( "Actions are complete, exiting", "" );
    System.exit( 1 );
   }

  public AirportClient( )
  {
    super( "Using the Airport Class" );

    setSize( 300, 350 );
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
      int sX = 50;

      int sY = 75;
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

      sY = 200;
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
       g.drawString( action1, 20, 320 );
       g.drawString( action2, 35, 335 );

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
    Pause.wait( animationPause );
  }

  public static void main( String [] args )
  {
    AirportClient app = new AirportClient( );
    app.workWithAirports( );
    app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}
