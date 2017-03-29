/** Book class
  * Anderson, Franceschi
  */

public class Book
{
  private String title;
  private String author;
  private double price;
  
  /** default constructor
    */
  public Book( )
  {
    this.title = "";
    this.author = "";
    this.price  = 0.0;
  }
  
  /** overloaded constructor
    *  @param newTitle   the value to assign to title
    *  @param newAuthor  the value to assign to author
    *  @param newPrice   the value to assign to price
    */
  public Book( String newTitle, String newAuthor, double newPrice )
  {
    this.title = newTitle;
    this.author = newAuthor;
    this.price  = newPrice;
  }
  
  /** getTitle accessor method
    *   @return the title
    */
  public String getTitle( )
  {
    return this.title;
  }
  
  /** getAuthor accessor method
    *   @return the author
    */
  public String getAuthor( )
  {
    return this.author;
  }
  
  /** getPrice accessor method
    *   @return the price
    */
  public double getPrice( )
  {
    return this.price;
  }
  
  /** toString
    * @return title, author, and price
    */
  public String toString( )
  {
    return ( "title: " + this.title + "\t"
              + "author: " + this.author + "\t"
              + "price: " + this.price );
  }
}
