/**  BookStore class
 * Anderson, Franceschi
 */

import java.util.ArrayList;

public class BookStore
{
  private ArrayList<Book> library;
  private final int NOT_FOUND = -1;
  
  /** default constructor
    *   instantiates ArrayList of Books
    */
  public BookStore( )
  {
    this.library = new ArrayList<Book>( );
    this.library.add( new Book( "Intro to Java", "James", 56.99 ) );
    this.library.add( new Book( "Advanced Java", "Green", 65.99 ) );
    this.library.add( new Book( "Java Servlets", "Brown", 75.99 ) );
    this.library.add( new Book( "Intro to HTML", "James", 29.49 ) );
    this.library.add( new Book( "Intro to Perl", "James", 34.99 ) );
    this.library.add( new Book( "Advanced HTML", "Greenberg", 56.99 ) );
    this.library.trimToSize( );
  }
  
  /** toString
    *  @return  each book in library, one per line
    */
  public String toString( )
  {
    String result = "";
    for( Book tempBook : this.library )
    {
      result += tempBook.toString( ) + "\n";
    }
    return result;
  }
  
  /** Generates list of books containing searchString
    *  @param searchString    the keyword to search for
    *  @return        the ArrayList of books containing the keyword
    */
  public ArrayList<Book> searchForTitle( String searchString )
  {
    ArrayList<Book> searchResult = new ArrayList<Book>( );
    for ( Book currentBook : this.library )
    {
      if ( ( currentBook.getTitle( ).toLowerCase() ).indexOf( searchString ) != NOT_FOUND )
        searchResult.add( currentBook );
    }
    searchResult.trimToSize( );
    return searchResult;
  }

  public ArrayList<Book> searchForAuthor ( String searchString)
  {
      ArrayList<Book> searchResult = new ArrayList<Book>();
      for ( Book currentBook : this.library )
      {
          if ((currentBook.getAuthor().toLowerCase()).indexOf(searchString) != NOT_FOUND )
          {
              searchResult.add(currentBook);
          }
      }
      searchResult.trimToSize();
      return searchResult;
  }

  public ArrayList<Book> searchForLowerPrice ( double searchPrice)
  {
      ArrayList<Book> searchResult = new ArrayList<Book>();
      for ( Book currentBook : this.library )
      {
          if (currentBook.getPrice() < searchPrice)
          {
              searchResult.add(currentBook);
          }
      }
      searchResult.trimToSize();
      return searchResult;
  }

  public Book lowestPrice ()
  {
      Book currentLowestBook = this.library.get(0);
      for (int i = 1; i < this.library.size(); i++)
      {
          if (this.library.get(i).getPrice() < currentLowestBook.getPrice())
          {
              currentLowestBook = this.library.get(i);
          }
      }
      return currentLowestBook;
  }


}
