import java.util.Scanner;

/**
 * Guessing game of OddOrEven.
 *
 * @author: YOUR NAME
 * @version: 10/11/14
 */
public class PlayGame
{
    // Declare instance variables here

    private Player player1;
    private Player player2;
    private Dealer dealer;
    private final int MAX_ROUNDS = 5;
    /**
     * Constructor
     * <p/>
     * 1. creates the dealer object
     * 2. creates players objects
     * 3. plays the MAX_ROUNDS of rounds. For each round:
     *    a. asks dealer to shake the dice cup
     *    b. asks each player for their guess
     *    c. calls roundResults method to display the round statistics
     *
     * @param player1Name name of the player 1 as entered by the user
     * @param player2Name name of the player 2 as entered by the user
     */
    public PlayGame(String player1Name, String player2Name)
    {
        // Create the dealer
        dealer = new Dealer();

        // Create the two players
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);

        // Play the rounds

        for (int i = 0; i <= MAX_ROUNDS; i++)
        {
            dealer.shakeDiceCup();
            player1.makeGuess();
            player2.makeGuess();
            roundResults();
        }
      
    }

    /**
     * The roundResults method determines the results of the current round
     * Displays the dealer's data and checks each player's guess
     * against the dealer's result. Awards a point to a player if (s)he guessed correctly.
     * Displays the appropriate message(s)
     */
    private void roundResults()
    {

        // show the dice values rolled by the dealer
       System.out.println("The dealer rolled ");

        // check each player guess and award points

    }

    /**
     * The displayGrandWinner method displays the game's grand winner or a tie
     */
    public void displayGrandWinner()
    {
        System.out.println();
        System.out.println("\n*** Game over. Here are the results ***");
        
        
        System.out.println("In displayGrandWinner method - IMPLEMENT ME");
    }
}