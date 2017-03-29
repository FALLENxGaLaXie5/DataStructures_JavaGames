/* Sentence Type Identifier
*  Joshua Steward
*/
import java.util.Scanner;
public class SentenceType
{
    public static void main( String [] args )
    {
        Scanner scan = new Scanner( System.in );
        System.out.print("Enter a sentence: ");
        String sentence = scan.nextLine();
        String result = "";
        // extract last character of sentence


        if (sentence.length() > 0)
        {
            char lastChar = sentence.charAt( sentence.length( ) - 1 );
            switch (lastChar)
            {
                case '.':
                    result = "The sentence is declarative.";
                    break;
                case '?':
                    result = "The sentence is a question.";
                    break;
                case '!':
                    result = "The sentence is exclamatory.";
                    break;
                default:
                    result = "Sentence type is unknown.";

            }
        }
        else
        {
            result = "This is an empty string!";
        }
        System.out.println(result);
    }
}