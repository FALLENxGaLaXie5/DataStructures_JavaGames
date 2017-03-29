import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Created by Joshua Steward on 1/10/2015.
 */
public class GameDriver
{
    public static void main( String [] args)
    {
        int boardSize;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of board: (length will be the same as width, so just one integer)");
        try
        {
            boardSize = scan.nextInt();
        }
        catch (InputMismatchException ime)
        {
            System.out.println("Must be an integer.");
            System.out.println("Enter size of board: ");
            boardSize = scan.nextInt();
        }

        Board board1 = new Board(boardSize);
        board1.printBoard();
    }
}
