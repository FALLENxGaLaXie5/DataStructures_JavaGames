/* VacationClient class
   Anderson, Franceschi
*/

import java.text.DecimalFormat;

public class ShapeClient
{
  public static void main( String [] args )
  {
    // Line below would generate a compiler error
    // Shape shape = new Shape( );

    DecimalFormat pattern = new DecimalFormat( "#,##0.00" );
           // testing Circle class
    Circle circle1 = new Circle( 5 );
    System.out.println( "The circle1 is: " + circle1 );

    System.out.println( "The area of circle1 is: " + pattern.format(circle1.calculateArea()));
    System.out.println( "The perimiter of circle1 is: " + pattern.format(circle1.calculatePerimeter()));
    System.out.println();

    Circle circle2 = new Circle( 15 );
    System.out.println( "The circle2 is: " + circle2 );

    System.out.println( "The area of circle2 is: " + pattern.format(circle2.calculateArea()));
    System.out.println( "The perimiter of circle2 is: " + pattern.format(circle2.calculatePerimeter()));
    System.out.println();   
                  //testing Circle equals method
    if ( circle1.equals( circle2 ) )
      System.out.println( "circle1 and circle2 are equal - incorrect" );
    else
      System.out.println( "circle1 and circle2 are not equal - correct" );
    
    System.out.println("Chenging the radius of circle1 to 15");
    circle1.setRadius( 15 );
    
    if ( circle1.equals( circle2 ) )
      System.out.println( "circle1 and circle2 are equal - correct" );
    else
      System.out.println( "circle1 and circle2 are not equal - incorrect" );
    System.out.println();
    
    circle2.setRadius( -3 );
    System.out.println( "circle2 after changing radius to -3 is: " + circle2 );
    
         // Testing Rectangle class

    Rectangle rectangle1 = new Rectangle( 5, 5 );
    System.out.println( "The rectangle1 is: " + rectangle1 );

    System.out.println( "The area of rectangle1 is: " + pattern.format(rectangle1.calculateArea()));
    System.out.println( "The perimiter of rectangle1 is: " + pattern.format(rectangle1.calculatePerimeter()));
    System.out.println();

    Rectangle rectangle2 = new Rectangle( 15, 20 );
    System.out.println( "The rectangle2 is: " + rectangle2 );

    System.out.println( "The area of rectangle2 is: " + pattern.format(rectangle2.calculateArea()));
    System.out.println( "The perimiter of rectangle2 is: " + pattern.format(rectangle2.calculatePerimeter()));
    System.out.println();   
                  //testing Rectangle equals method
    if ( rectangle1.equals( rectangle2 ) )
      System.out.println( "rectangle1 and rectangle2 are equal - incorrect" );
    else
      System.out.println( "rectangle1 and rectangle2 are not equal - correct" );
    
    rectangle2.setWidth( 5 );
    rectangle2.setHeight( 5 );
    
    if ( rectangle1.equals( rectangle2 ) )
      System.out.println( "rectangle1 and rectangle2 are equal - correct" );
    else
      System.out.println( "rectangle1 and rectangle2 are not equal - incorrect" );
    
    rectangle1.setWidth( -3 );
    rectangle1.setHeight( 0 );
    System.out.println( "rectangle1 after changing width to -3 and hight to 0 is: " + rectangle1 );
  }
}
