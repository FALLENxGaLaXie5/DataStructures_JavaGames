/* Palindrome
*  Anderson, Franceschi
*/

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Palindrome
{
 // upper left cordinates of start of animation
 private static final int X_START = 100;
 private static final int Y_START = 50;

 // String representing the String
 private String pal;
 // boolean representing the exact result
 private boolean exactResult;
 // boolean representing the computed computed by the student
 private boolean result;
 // String array representing the various Strings
 // as they are called by the recursive method
 private String [] arrPal;
 // current index of arrPal
 int index;

 // animation started or not
 private boolean started = false;
 // exact result already computed or not
 private boolean resultSet = false;

 public Palindrome( String s )
 {
  pal = s;
  arrPal = new String[20];
  arrPal[0] = s;
  index = -1;
  exactResult = calcExactResult( pal );
  result = false;
 }

 public Palindrome( )
 {
  pal = "";
  arrPal = new String[20];
  index = -1;
  exactResult = false;
  result = false;
 }

 public void setResult( boolean r )
 {
  result = r;
  resultSet = true;
 }

 public void setPalString( String s )
 {
  pal = s;
  arrPal[0] = s;
  index = -1;
  resultSet = false;
  exactResult = calcExactResult( pal );
 }

 public String getPalString( )
 {
  return pal;
 }

 public void setStarted( boolean s )
 {
  started = s;
 }

 public boolean calcExactResult( String s )
 {
    if ( s.length( ) <= 1 )
        return true;
    else if ( s.substring( 0, 1 ).equalsIgnoreCase( s.substring( s.length( ) - 1, s.length( ) ) ) )
        return calcExactResult( s.substring( 1, s.length( ) - 1 ) );
    else
        return false;
 }

 public boolean getExactResult( )
 {
  return exactResult;
 }

 public void updatePalindrome( String newS )
 {
  index++;
  arrPal[index] = newS;
 }

 public String convertResult( boolean finalResult )
 {
  if ( finalResult )
    return " is a palindrome";
  else
    return " is not a palindrome";
 }

 public void draw( Graphics g )
 {
  String temp = "";
  if ( started )
  {
   g.setFont( new Font( "Courier", Font.PLAIN, 18 ) );
   g.setColor( Color.BLUE );

   for ( int i = 0; i <= index; i++ )
   {
    g.drawString( arrPal[i], X_START + 11 * i, Y_START + i * 20 );
   }

   if ( resultSet )
   {
    g.setFont( new Font( "Serif", Font.BOLD, 18 ) );
    g.setColor( Color.RED );
    g.drawString( "Your result is: " + pal + convertResult( result ), X_START / 4, Y_START + ( index + 2 ) * 20 );
    g.setColor( new Color( 0, 255, 127 ) );
    g.drawString( "The correct result is: " + pal + convertResult( exactResult ), X_START / 4, Y_START + ( index + 4 ) * 20 );
   }
  }
 }
}