/**
 *
 * @author Joshua Steward
 * @version 3/31/2015
 */
 
import java.util.*;

public class BingoGame 
{
	private final int NUM_OF_CHIPS = 75;
	private int numOfPlayers;
	private ArrayList<BingoChip> bingoDrum;
	private BingoCard[] playersCards;

	public BingoGame(int numOfPlayers) 
	{
		setNumOfPlayers(numOfPlayers);
		createBingoDrum();
		createPlayersCards();
	}


	/**
	 * creats new bingoDrum object new Array list with number of chips specified
	 */
	private void createBingoDrum()
	{
		this.bingoDrum = new ArrayList<>(this.NUM_OF_CHIPS);
	}
	
	private void createPlayersCards()
	{
		this.playersCards = new BingoCard[this.numOfPlayers];
	}
	
	private void setNumOfPlayers(int numOfPlayers)
	{
		this.numOfPlayers = numOfPlayers;
	}

	public int getNumberOfChips()
	{
		return this.NUM_OF_CHIPS;
	}

	public BingoChip pullChip()
	{
		Random generator = new Random();
		return this.bingoDrum.remove(generator.nextInt(this.NUM_OF_CHIPS));
	}
	
	public void play()
	{
		boolean winnerFound = false;
		int numOfChipsCalled = 0;
		while (!winnerFound)
		{
			BingoChip pulledChip = this.pullChip();
			numOfChipsCalled++;
			for (int i = 0; i < this.numOfPlayers && !winnerFound; i++)
			{
				this.playersCards[i].checkNumber(pulledChip);
				this.playersCards[i].printCard();
				winnerFound = this.playersCards[i].isWinner();
				if (winnerFound)
				{
					int winningPlayer = i + 1;
					System.out.println("!!! Player " + winningPlayer + " says BINGO !!!");
				}
			}
		}
		System.out.println(numOfChipsCalled + " chips were called.");
	}
}