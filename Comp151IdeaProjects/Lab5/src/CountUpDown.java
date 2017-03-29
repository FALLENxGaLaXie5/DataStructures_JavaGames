import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The class recursively counts down and up from the number
 * given by the user.
 *
 * @author YOUR NAME
 * @version 02/12/2015
 */

public class CountUpDown
{
    /**
     * countUp - a recursive function that counts up from 1 to n
     *
     * @param n    the integer value to count up to
     */
    private static void countUp(int n)
    {
        // IMPLEMENT THIS RECURSIVE METHOD

    }

    /**
     * countDown - a recursive function that counts down from n to 1
     *
     * @param n    the integer value to count down from
     */
    private static void countDown(int n)
    {
        // IMPLEMENT THIS RECURSIVE METHOD

    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int n = 10;        //default value is 10
        try
        {
            System.out.println("Please enter an integer value greater than 0");
            n = input.nextInt();
            if (n <= 0)
            {
                n = 10;
                throw new Exception();
            }

        }
        catch(InputMismatchException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println("Will use 10 as the default value");
        }
        catch(Exception e)
        {
            System.out.println("There was an error with the input value");
            System.out.println("Will use 10 as the default value");
        }

        System.out.println();
        System.out.println("Should count down to 1");
        countDown(n);

        System.out.println();
        System.out.println("Should count up from 1");
        countUp(n);
    }
}