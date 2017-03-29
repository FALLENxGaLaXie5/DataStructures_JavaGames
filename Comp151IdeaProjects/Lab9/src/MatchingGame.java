import java.util.*;

/**
 *
 * @author Joshua Steward
 * @version 2/26/2015
 */
public class MatchingGame
{
    private ArrayList<Integer> theNumbers;
    final int MAX_NUMBER_OF_SHUFFLES = 5;
    final int MIN_NUMBER = 10;
    final int MAX_NUMBER = 99;

    public MatchingGame(int numberAmount)
    {
        this.theNumbers = new ArrayList<>();
        initializeList(numberAmount);
    }

    /**
     * Initialize the list with the count of random 2 digit numbers.
     *
     */
    private void initializeList(int numberAmount)
    {
        Random generator = new Random();
        ListIterator<Integer> iter = this.theNumbers.listIterator();

        // STEP 1
        // generate the numbers and add them to theNumbers using iterator
        while (iter.hasNext())
        {

        }
    }

    /**
     * See whether two numbers are removable.
     * @param first the first 2 digit integer value
     * @param second the second 2 digit integer value
     * @return true if the first and second match
     */
    private boolean removablePair(Integer first, Integer second)
    {
        // STEP3
        // implement this method
        return false;
    }

    /**
     * Implements one pass when called by play method
     * Scans over the list and removes any pairs of values that are removable.
     * @return true if any pair of integers was removed
     */
    private boolean scanAndRemovePairs()
    {
        boolean removedAPair = false;
        ListIterator<Integer> scan = this.theNumbers.listIterator();

        Integer first = null;
        Integer second = null;

        // STEP4
        // implement the method
        // this method calls helper method removablePair to see if there is a match
        return removedAPair;
    }

    private void displayTheNumbers()
    {
        // STEP2
        // using an instance of Iterator display the content of theNumbers
        // notify the user if the list is empty
    }

    public void play()
    {
        int pass = 0;
        int numberOfShuffles = 0;
        boolean repeat;

        System.out.println("Starting with: ");
        displayTheNumbers();

        do
        {
            repeat = false;
            while (scanAndRemovePairs())
            {
                pass++;
                System.out.println("The list after pass #" + pass);
                displayTheNumbers();
            }
            System.out.println("No more pairs to remove.");
            // do we have at least 3 numbers in the list?
            if (this.theNumbers.size() > 2)
            {
                if (numberOfShuffles < MAX_NUMBER_OF_SHUFFLES)
                {
                    numberOfShuffles++;
                    System.out.println("Shuffling the numbers.");
                    Collections.shuffle(this.theNumbers);
                    System.out.println("The list after shuffling #" + numberOfShuffles);
                    displayTheNumbers();
                    repeat = true;
                }
            }
        }while(repeat);

        if (this.theNumbers.isEmpty())
        {
            System.out.println("\n*** Winner!!! ***");
        }
        else
        {
            System.out.println("\n*** Better luck next time! ***");
        }
    }

    public static void main(String[] args)
    {
        final int MIN_NUMBER_OF_ELEMENTS = 10;
        Scanner scan = new Scanner(System.in);
        int numberAmount;

        do
        {
            System.out.println("How many numbers (no less than " + MIN_NUMBER_OF_ELEMENTS + ")?");
            numberAmount = scan.nextInt();
        }while(numberAmount < MIN_NUMBER_OF_ELEMENTS);

        MatchingGame game = new MatchingGame(numberAmount);
        game.play();
    }
}