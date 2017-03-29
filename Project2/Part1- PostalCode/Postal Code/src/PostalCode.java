/**
 * SERVICE CLASS Translate ZIP code into its bar code representation
 * 
 * Joshua Steward
 * @version 10/11/2014
 */


public class PostalCode 
{
  /**
   * Instance variable. <BR>
   * Contains the zipCode in a DDDDD-DDDD format
   * (for example 12345-6789)
   */
  private String zipCode;
  private String barCode;
  
  /**
   * Secondary constructor.<BR>
   * Allows user to provide the value of the zipCode
   * 
   * @param zipCode initial value of the zipCode
   */
  public PostalCode(String zipCode) 
  {
    setZipCode(zipCode);
  }
  
  /**
   * Mutator method.<BR> 
   * Sets the value of a zipCode to the given new value
   * and sets the barCode to the bar code representation of the zipCode
   * 
   * @param zipCode
   */
  public void setZipCode(String zipCode) 
  {
    this.zipCode = zipCode;
    setBarCode();
  }
  
  /**
   * private mutator method that converts the zipCode into the bar code format 
   * and sas it in a barCode instance variable.
   */
  private void setBarCode() 
  {
    // IMPLEMENT THIS METHOD
    
    // 1. first remove all '-' for easy processing
      String zipString = this.zipCode.replaceAll("[ -]", "");

    // 2. calculate the checksum by calling the private calculateChecksum method
      int checksum = calculateChecksum(zipString);
    
    // 3. calculate the check digit by calling the private calculateCheckDigit method
      int checkdigit = calculateCheckDigit(checksum);
    
    // 4. append the check digit to the zip string for final processing
      zipString = zipString + checkdigit;
    
    // 5. produce the bar code and save it in barCode instance variable
    //    use a for loop and a switch inside the loop

      this.barCode = "|";
      for (int i = 0; i < zipString.length(); i++)
      {
          char currentChar = zipString.charAt(i);
          switch (currentChar)
          {
              case '1':
                  this.barCode += ":::||";
                  break;
              case '2':
                  this.barCode += "::|:|";
                  break;
              case '3':
                  this.barCode += "::||:";
                  break;
              case '4':
                  this.barCode += ":|::|";
                  break;
              case '5':
                  this.barCode += ":|:|:";
                  break;
              case '6':
                  this.barCode += ":||::";
                  break;
              case '7':
                  this.barCode += "|:::|";
                  break;
              case '8':
                  this.barCode += "|::|:";
                  break;
              case '9':
                  this.barCode += "|:|::";
                  break;
              case '0':
                  this.barCode += "||:::";
                  break;
              default:
                  break;


          }
      }
      this.barCode += '|';
  }
  
  /**
   * Business method that calculates the checksum for the given zipCode.
   * 
   * @param zipStr the zipCode without spaces and '-'
   * @return checkSum
   */
  private int calculateChecksum(String zipStr) 
  {
    int checkSum = 0;
    for (int i = 0; i < zipStr.length(); i++)
    {
        int currentDigit = Character.digit(zipStr.charAt(i), 10);
        checkSum += currentDigit;

    }
    return checkSum;
    // IMPLEMENT THIS METHOD
    // HINT: to get the numberic value of each character
    //       utilize Character.digit(zipStr.charAt(i),10) method inside 
    //       a for loop which runs over zipStr string 

    //return 0; // <-- this is a stub added for compilation
  }
  
  /**
   * Business method that calculates the check digit.
   * 
   * @param checkSum sum of the zipCode digits
   * @return check digit
   */
  private int calculateCheckDigit(int checkSum) 
  {
    int checkDigit = 0;
    int check = checkSum % 10;
      if(check == 0)
      {
          checkDigit = 0;
      }
      else
      {
          checkDigit = 10 - check;
      }


    return checkDigit;

    // IMPLEMENT THIS METHOD
    
    //return 0; // <-- this is a stub added for compilation
  }
  
  
  /**
   * Accessor method.
   * 
   * @return the instance variable barCode
   */
  public String getBarCode() 
  {
    return this.barCode;
  }
  
  /**
   * Accessor method.
   * 
   * @return the instance variable zipCode
   */
  public String getZipCode() 
  {
    return this.zipCode;
  }
  
   /**
   * toString method.
   * 
   * @return the string representation of the PostalCode object
   */
  public String toString()
  {
    return "The zip string to be processed is "
            + this.zipCode.replaceAll("-", "")
            + ".\nThe checksum is " + calculateChecksum(this.zipCode.replaceAll("-", ""))
            + ".\nThe zip with the check digit is " + this.zipCode.replaceAll("-", "") + calculateCheckDigit(calculateChecksum(this.zipCode.replaceAll("-", "")))
            + "\n\nThe zip code " + this.zipCode + " has the following bar code: \n"
            + this.barCode;
  }
}