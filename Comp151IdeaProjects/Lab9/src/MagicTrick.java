import java.util.*;

/**
 * MagicTrick is a program that will guess a number that user is thinking of.
 *
 * @author Joshua Steward
 * @version 02/26/2015
 */
public class MagicTrick
{
    public final int NUM_OF_SEQUENCES = 5;
    public final int NUMBERS_PER_SEQUENCE = 16;
    private ArrayList<Integer>[] sequences;

    public MagicTrick()
    {
        this.sequences = new ArrayList[NUM_OF_SEQUENCES];
        Integer adder = 1;
        this.sequences[1].add(adder);
        for (int i = 0; i < NUMBERS_PER_SEQUENCE; i++)
        {
            adder += 2;
        }
    }

    public void displaySequences()
    {

    }

    public void guessNumber(String[] answer)
    {

    }

    public static void main(String[] args)
    {
        MagicTrick magic = new MagicTrick();
        System.out.println("Think of a number between 1 and 31\n");
        magic.displaySequences();

        System.out.println("\nList all the sequences that your number is in (ie. 1 3)");
        Scanner scan = new Scanner(System.in);
        magic.guessNumber(scan.nextLine().split(" "));
    }
}
