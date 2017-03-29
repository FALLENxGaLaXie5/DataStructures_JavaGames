/**
 *
 * @author YOUR NAME
 * @version 3/31/2015
 */
 
import java.util.*;
public class PlayBingo 
{
	public static void main(String[] args) 
	{
		System.out.println("---> Setting up bingo game.");
		
		Scanner scan = new Scanner(System.in);
		int numOfPlayers;
		do
		{
			System.out.println("Enter number of players.");
			numOfPlayers = scan.nextInt();
		}while (numOfPlayers < 1);
		
		BingoGame game = new BingoGame(numOfPlayers);
		
		System.out.println("---> Starting the game with " + numOfPlayers + " players:");
		System.out.println("     *********************************\n");
		game.play();
	}
}