/* Store Class
 Anderson, Franceschi
 */

public class Store
{
  public final double SALES_TAX_RATE = 0.06;
  private String name;
  
  /**
   * Overloaded constructor:<BR>
   * Allows client to set beginning value for name
   * This constructor takes one parameter<BR>
   * Calls mutator method
   * @param newName the name of the store
   */
  public Store( String newName )
  {
    setName( newName );
  }
  
  /** getName method
    * @return a String, the name of the store
    */
  public String getName( )
  {
    return this.name;
  }
  
  /**
   * Mutator method:<BR>
   * Allows client to set value of name
   * @param newName the new name for the store
   */
  public void setName( String newName )
  {
    this.name = newName;
  }
  
  /**
   * @return a string representation of the store
   */
  public String toString( )
  {
    return( "name: " + this.name );
  }
  
  /**
   * equals method
   * Compares two Store objects for the same field value
   * @param other another Store object
   * @return a boolean, true if this object
   * has the same field value as the parameter other
   */
  public boolean equals( Store other )
  {
      return ( this.name.equalsIgnoreCase( other.name ) );
  }
}