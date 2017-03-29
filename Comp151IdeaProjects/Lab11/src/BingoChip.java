/**
 *
 * @author Joshua Steward
 * @version 03/31/2015
 */

public class BingoChip 
{
	private char letter;
	private int number;

	public BingoChip(int number)
	{
		setNumber( number );		
		setLetter();		
	}

	private void setNumber(int number)
	{
		this.number = number;
	}

	private void setLetter()
	{

	}

	public int getNumber()
	{
		return this.number;
	}

	public char getLetter()
	{
		return this.letter;
	}

	public String toString()
	{
		return "Calling: " + this.letter + " " + this.number;
	}
}