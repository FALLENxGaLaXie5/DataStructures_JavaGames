/**
 *
 * @author Joshua Steward
 * @version 3/31/2015
 */
 
import java.util.*;
public class BingoCard 
{
	private TreeSet<Character> bingoChars;
	private HashMap<Character, TreeSet<Integer>> card;
    public final static String BINGO_KEYS = "BINGO";
    public final static int MAX_VALUES_PER_LETTER = 15;
    public final static int NUMBERS_PER_LETTER = 5;

	public BingoCard()
	{
		Random generator = new Random();
		this.card = new HashMap<>(this.BINGO_KEYS.length());
		this.bingoChars = new TreeSet<>();
		for(int i = 0; i < this.BINGO_KEYS.length(); i++)
		{
			this.bingoChars.add(this.BINGO_KEYS.charAt(i));
		}

		this.printCard();
	}

	public void checkNumber(BingoChip chip)
	{
		char letter = chip.getLetter();
		int num = chip.getNumber();
		if (this.card.get(letter).contains(num))
		{
			this.card.get(letter).add(0);
		}
	}
	
	public boolean isWinner()
	{
		boolean flag = true;
		Object currentChar = ' ';
		Iterator iter = this.bingoChars.iterator();
		while (!iter.hasNext())
		{
			currentChar = iter.next();
			if (!this.card.get(currentChar).contains(0))
			{
				flag = false;
			}
		}
		return flag;
	}
	
	public void printCard()
	{
		Iterator iter = this.bingoChars.iterator();
		Object currentChar = ' ';
		while (!iter.hasNext())
		{
			currentChar = iter.next();
			System.out.print(currentChar);
			Iterator currentKeyIterator = this.card.get(currentChar).iterator();
			while (!currentKeyIterator.hasNext())
			{
				System.out.print(" " + currentKeyIterator.next());
			}
		}
	}
}