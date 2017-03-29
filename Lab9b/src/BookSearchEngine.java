/* BookSearchEngine class
 Anderson, Franceschi
 */

import java.util.*;

public class BookSearchEngine
{
  public static void main( String [] args )
  {
    BookStore bookStore = new BookStore( );
    System.out.println( "\nOur book collection is:" );
    System.out.println( bookStore );
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println( "\nSearching titles, enter a keyword" );
    String keyword = keyboard.next();   
    ArrayList<Book> resultTitle = bookStore.searchForTitle( keyword.toLowerCase() );
    System.out.println( "The search results for \"" + keyword
                         + "\" are:" );
    if (resultTitle.size() > 0)
    {
      for( Book tempBook : resultTitle )
        System.out.println( tempBook );
    }
    else
    {
      System.out.println("No book meeting your search criteria has been found");
    }

      System.out.println( "\nSearching authors, enter a keyword" );
      String keywordAuthor = keyboard.next();
      ArrayList<Book> resultAuthor = bookStore.searchForAuthor( keywordAuthor.toLowerCase() );
      System.out.println( "The search results for \"" + keywordAuthor
              + "\" are:" );
      if (resultAuthor.size() > 0)
      {
          for( Book tempBook : resultAuthor )
              System.out.println( tempBook );
      }
      else
      {
          System.out.println("No book meeting your search criteria has been found");
      }

      System.out.println( "\nEnter your budget: " );
      double comparePrice = keyboard.nextDouble();
      ArrayList<Book> resultPrices = bookStore.searchForLowerPrice( comparePrice );
      System.out.println( "The search results for books less than \"" + comparePrice
              + "\" are:" );
      if (resultPrices.size() > 0)
      {
          for( Book tempBook : resultPrices )
              System.out.println( tempBook );
      }
      else
      {
          System.out.println("No book meeting your search criteria has been found");
      }

    System.out.println("The book with the lowest price is: \n" + bookStore.lowestPrice());

  }
}
