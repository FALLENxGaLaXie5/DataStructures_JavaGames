/**
 * Dealer class for the game of Even Or Odd
 *
 * Joshua Steward
 * @version: 10/11/14
 */
public class Dealer
{
    // Declare instance variables here
    private Die die1;
    private Die die2;

    private int SIDES = 6;
    /**
     * Constructor  creates two Die objects
     */
    public Dealer()
    {
        die1 = new Die(this.SIDES);
        die2 = new Die(this.SIDES);
    }

    /**
     * The shakeDiceCup method rolls both dice
     */
    public void shakeDiceCup()
    {
        die1.roll();
        die2.roll();
    }

    /**
     * The calculateEvenOrOdd method returns the result of the dice roll
     *
     * @return EVEN if the sum of two dice roll is even, or ODD otherwise
     */
    public String calculateEvenOrOdd()
    {
        int sum = die1.getFace() + die2.getFace();

        return sum % 2== 0 ? "Even" : "Odd";  // THIS IS A STUB
    }

    /**
     * @return String representation of the dealer's roll
     */
    public String toString()
    {
        return "The dealer rolled a " + die1.getFace() + " and " + die2.getFace();   // THIS IS A STUB
    }
}