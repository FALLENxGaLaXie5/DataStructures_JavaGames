import java.util.Random;

/**
 * Player class for the game of Odd or Even
 *
 * @author: YOUR NAME
 * @version: 10/11/14
 */
public class Player
{
    private String playerName;
    private String guess;
    private int points;

    /**
     * Constructor  sets the name to the given playersName,
     *                   guess is set to empty string, and points to 0
     *
     * @param playerName The player's name
     */
    public Player(String playerName)
    {
        this.playerName = playerName;
        this.guess = "";
        this.points = 0;
    }

    /**
     * The makeGuess method causes the player to guess either EVEN or ODD
     * Creates a random object and utilizes nextBoolean method
     */
    public void makeGuess()
    {
        Random randomGuess = new Random();
        randomGuess.nextBoolean();
        if (randomGuess.equals(true))
        {
            this.guess = "EVEN";
        }
        else if (randomGuess.equals(false))
        {
            this.guess = "ODD";
        }
    }

    /**
     * The addPoint method adds one point to the player's current balance
     */
    public void addPoint()
    {
        points++;
    }

    /**
     * Accessor method
     *
     * @return the player's name field
     */
    public String getName()
    {
        return this.playerName; // THIS IS A STUB
    }

    /**
     * Accessor method
     *
     * @return the value of the guess field
     */
    public String getGuess()
    {
        return this.guess;  // THIS IS A STUB
    }

    /**
     * Accessor method
     *
     * @return the value of the points field
     */
    public int getPoints()
    {
        return this.points; // THIS IS A STUB
    }

    /**
     * @return the String representation of the content of the player's object:
     *                    only players name and the numbers of points are given
     */
    public String toString()
    {
        return this.playerName + " guessed " + this.guess;    // THIS IS A STUB
    }
}