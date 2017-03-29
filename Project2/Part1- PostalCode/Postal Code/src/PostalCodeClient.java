/**
 * CLIENT CLASS Translate ZIP code into its bar code representation
 * 
 * Joshua Steward
 * @version 10/11/2014
 */
import java.util.*;

public class PostalCodeClient 
{
  public static void main(String[] args) 
  {
    final String VALID_AREA_CODE = "[0-9]{5}[-][0-9]{4}";
    
    String zipInputStr;
    boolean valid;
    String answer;
    
    //get and validate user's input
    Scanner keyboard = new Scanner(System.in);
    do 
    {
      do 
      {
        System.out.println("Enter a ZIP code in the form DDDDD-DDDD");
        zipInputStr = keyboard.nextLine();
        valid = zipInputStr.matches(VALID_AREA_CODE);
        if (!valid) 
        {
          System.out.println("Your input is invalid, please re-enter");
        }
      } while (!valid);
      
      // create postalCode object
      PostalCode postalCode = new PostalCode(zipInputStr);
      
      // display the zipCode and its barCode
      System.out.println(postalCode);
      
      // check if the user wants to convert another zipCode
      System.out.println();
      System.out.println("Would you like to generate another bar code?");
      answer = keyboard.nextLine();
    } while (answer.equalsIgnoreCase("yes"));
    System.out.println("Goodbye!");
  }
}