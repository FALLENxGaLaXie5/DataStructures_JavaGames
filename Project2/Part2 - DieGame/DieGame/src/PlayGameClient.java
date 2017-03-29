import java.util.Scanner;

/**
 * CLIENT CLASS for guessing game of OddOrEven.
 *
 * @author: YOUR NAME
 * @version: 10/11/14
 */
public class PlayGameClient
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        do
        {
            // Get the players names
            System.out.println("Enter the name of the first player");
            String player1Name = keyboard.nextLine();
            System.out.println("Enter the name of the second player");
            String player2Name = keyboard.nextLine();

            // Start and play the game
            PlayGame game = new PlayGame(player1Name, player2Name);
            // Display the overall winner
            game.displayGrandWinner();
            System.out.println("\nWould you like to play again? (yes/no)");
        } while (keyboard.nextLine().equalsIgnoreCase("yes"));
        System.out.println("Goodbye!");
    }
}
