//SentenceChecker
//Joshua Steward

/**
 * SentenceChecker
 * Created by Joshua on 9/24/2014.
 */
import java.util.Scanner;

public class SentenceChecker
{
    public static void main(String[] args)
    {
        //final String valid = "";
        //final String invalid = "The sentence is invalid!";
        Scanner scan = new Scanner ( System.in );
        System.out.print("Please enter a sentence that consists of letters only and ends with a period, " +
                "an exclamation mark, or a question mark: ");

        String sentence = scan.nextLine();
        String VALID_SENTENCE = "[a-zA-Z ]*[.!?]";

        if (sentence.matches(VALID_SENTENCE))
        {
            String mod = sentence.replaceAll("[aeiou]","@");
            System.out.println("The entered input: " + "\"" + sentence + "\"");
            System.out.println("With all vowels replaced is: " + "\"" + mod + "\"");
        }
        else
        {
            System.out.println("The entered input, " + "\"" + sentence + "\"" + " is invalid!");
        }

    }
}
