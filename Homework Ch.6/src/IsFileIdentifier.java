/**
 * Is File Identifier
 * Created by Joshua Steward on 10/4/2014.
 */
import java.util.*;
import java.io.File;
import java.io.IOException;


public class IsFileIdentifier
{
    public static void main( String [] args ) throws IOException
    {
        File inputFile = new File("Logic.txt");
        Scanner scan = new Scanner(inputFile);
        //int i = 0;
        String str;
        String startStr;
        int countIsStart = 0;
        //final String VALID_VOWEL_PATTERN = "[aeiou]";
        while ( scan.hasNext())
        {
            int i = 0;
            str = scan.next();
            startStr = str.substring(0, 2);
            if (startStr.equals("is"))
            {
                countIsStart ++;
            }
            while (i < str.length())
            {
                char currentCharacter = str.charAt(i);
                switch (currentCharacter)
                {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        System.out.print("~");
                        break;
                    default:
                        System.out.print(str.charAt(i));
                        break;
                }
            i ++;
            }
        }

    }
}
