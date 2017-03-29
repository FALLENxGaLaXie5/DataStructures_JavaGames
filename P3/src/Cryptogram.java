/**
 * Created by joshua.steward095 on 10/29/2014.
 */
import java.util.Random;
public class Cryptogram
{
    private char [] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f'
            , 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'
            , 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private int [] letterCounters;

    private char [] cryptCode;

    public Cryptogram()
    {
        this.letterCounters = new int[this.ALPHABET.length];
        setCryptCode();
    }

    public void setCryptCode()
    {
        this.cryptCode = new char[this.ALPHABET.length];
        for (int i = 0; i < this.ALPHABET.length; i++)
        {
            this.cryptCode[i] = this.ALPHABET[i];
        }

        Random random = new Random();

        for (int i = 0; i < this.cryptCode.length; i++)
        {
            int number = random.nextInt(this.cryptCode.length);
            char temp = this.cryptCode[i];
            this.cryptCode[i] = this.cryptCode[number];
            this.cryptCode[number] = temp;
        }
    }

    public int findLetterInAlphabet(char letter)
    {
        int num = -1;
        for (int i = 0; i < ALPHABET.length; i++)
        {
            if (letter == ALPHABET[i])
            {
                num = i;
            }
        }
        if (num >= 0)
        {
            letterCounters[num]++;
        }
        return num;
    }

    public String encrypt(String input)
    {
        input = input.toLowerCase();
        String output = "";
        for (int i = 0; i < input.length(); i++)
        {
            int num = findLetterInAlphabet(input.charAt(i));
            if (num < 0)
            {
                output += input.charAt(i);
            }
            else
            {
                output += cryptCode[num];
            }

        }
        return output;
    }

    public int findLetterInCryptCode(char letter)
    {
        int num = -1;
        for (int i = 0; i < cryptCode.length; i++)
        {
            if (letter == cryptCode[i])
            {
                num = i;
            }
        }

        return num;
    }

    public String decrypt(String input)
    {
        input = input.toLowerCase();
        String output = "";
        for (int i = 0; i < input.length(); i++)
        {
            int num = findLetterInCryptCode(input.charAt(i));
            if (num < 0)
            {
             output += input.charAt(i);
            }
            else
            {
                output += ALPHABET[num];
            }
        }
        return output;
    }

    public void displayStatistics()
    {
        int total = 0;
        for (int i = 0; i < letterCounters.length; i++)
        {
            total += letterCounters[i];
        }

        for (int i = 0; i < letterCounters.length; i++)
        {

        }
    }

    //public String toString()
   // {
//
 //   }
}
