/**
 * Write a program that checks the result of sequence of 1s multiplied 
 * by the same sequence of 1s for palindrome.
 *
 * Your program should produce the following output:
 *  1 * 1 is 1 - and it is a PALINDROME
 *  11 * 11 is 121 - and it is a PALINDROME
 *  111 * 111 is 12321 - and it is a PALINDROME
 *  1111 * 1111 is 1234321 - and it is a PALINDROME
 *  11111 * 11111 is 123454321 - and it is a PALINDROME
 *  111111 * 111111 is 12345654321 - and it is a PALINDROME
 *  1111111 * 1111111 is 1234567654321 - and it is a PALINDROME
 *  11111111 * 11111111 is 123456787654321 - and it is a PALINDROME
 *  111111111 * 111111111 is 12345678987654321 - and it is a PALINDROME
 *  1111111111 * 1111111111 is 1234567900987654321 - and it is NOT a PALINDROME.
 *
 * @author YOUR NAME
 * @version 02/12/2015
 */
import java.math.BigInteger;

public class Elevens
{
    private static boolean isPalindrome(BigInteger number)
    {
        boolean pal = true;
        String checkMe = number.toString();
        for (int i=0; i<checkMe.length()/2 && pal; i++)
        {
            if (checkMe.charAt(i) != checkMe.charAt(checkMe.length() - i - 1))
                pal = false;
        }
        return pal;
    }

    private static void elevenPals(BigInteger ones)
    {
        BigInteger result = ones.multiply(ones);
        System.out.print(ones + " * " + ones + " is " + result);
        boolean pal = isPalindrome(result);
        System.out.println(" - and it is " + (pal?"":"NOT ") + "a PALINDROME");

        // IMPLEMENT RECURSIVE CALL HERE
        // UTILIZE CONSTANTS FROM BigInteger CLASS
    }

    public static void main(String args[])
    {
        BigInteger ones = new BigInteger("1");

        elevenPals(ones);
    }
}
