import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * A class that represents Pascal Triangles.
 *
 * @author Joshua Steward
 * @version 2/26/2015
 */
public class PascalTriangle
{
    private List<ArrayList<Integer>> triangle;
    private static final int DEFAULT_NUMBER_OF_ROWS = 10;
    private static final int INVALID_INPUT = -1;

    public PascalTriangle()
    {
        this.triangle = new ArrayList<>(this.DEFAULT_NUMBER_OF_ROWS);
        for (int i = 0; i < this.DEFAULT_NUMBER_OF_ROWS; i++)
        {
            createNextRow(i);
        }
    } // end default constructor

    /**
     * Precondition: numberOfRows > 1
     * <p/>
     * The constructor creates the this.triangle object - list of list filled
     * with Integers that are calculated to produce proper Pascal Triangle property.
     * Utilizes createNextRow private method
     */
    public PascalTriangle(int numberOfRows)
    {
        this.triangle = new ArrayList<>(numberOfRows);
        for (int i = 0; i < numberOfRows; i++)
        {
            createNextRow(i);
        }
    } // end constructor

    /**
     * Returns the list that represents the row whose index is rowIndex.
     */

    private ArrayList<Integer> createNextRow(int rowIndex)
    {
        ArrayList<Integer> nextRow = new ArrayList<>(rowIndex + 1);
        if (rowIndex == 0)
        {
            nextRow.add(1);
        }
        else if (rowIndex == 1)
        {
            nextRow.add(1);
            nextRow.add(1);
        }
        else if (rowIndex >= 2)
        {
            ArrayList<Integer> previousRow = this.triangle.get(rowIndex - 1);
            nextRow.add(1);
            for (int i = 1; i < nextRow.size() - 1; i++)
            {
                nextRow.add(previousRow.get(i) + previousRow.get(i - 1));
            }
            nextRow.add(1);
        }
        return nextRow;
    } // end createNextRow

    /**
     * prints the content of the this.triangle object
     * MUST USE FOR-EACH LOOPS
     */
    public void display()
    {
        for (ArrayList currentList : this.triangle)
        {
            for (Integer currentInt : this.triangle.get(this.triangle.indexOf(currentList)))
            {
                System.out.println(currentInt);
            }
        }
        // MUST USE FOR-EACH LOOPS
    }

    /**
     * calculates and prints the sums of integers in each row of this.triangle
     * MUST USE ITERATORS
     */
    public void printHorizontalSums()
    {
        ArrayList<Integer> nextRow;
        while (this.triangle.listIterator().hasNext())
        {
            nextRow = this.triangle.listIterator().next();
            Integer total = 0;
            while (nextRow.listIterator().hasNext())
            {
                total += nextRow.listIterator().next();
            }
            System.out.println(total);
        }
        // MUST USE ITERATORS
    }

    /**
     * @param totalObjects            - total number of objects
     * @param numberOfObjectsToChoose
     * @return number representing how many combinations of objects are possible
     *         or -1 if the input is invalid
     */
    public int howManyWays(int totalObjects, int numberOfObjectsToChoose)
    {
        int numOfWays = INVALID_INPUT;
        if (numberOfObjectsToChoose > 0 && totalObjects > 0)
        {
            ArrayList<Integer> row = this.triangle.get(totalObjects);
            numOfWays = row.get(numberOfObjectsToChoose);
        }
        return numOfWays; // THIS IS A STUB
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int triangleSize = 0;
        do
        {
            try
            {
                System.out.println("Please enter the triangle size that is greater than 1");
                triangleSize = scanner.nextInt();
            } catch (Exception e)
            {
                System.err.println("Invalid input");
            }
        } while (triangleSize <= 1);

        PascalTriangle triangle = new PascalTriangle(triangleSize);
        triangle.display();
        System.out.println("\nHorizontal sums are:");
        triangle.printHorizontalSums();
        System.out.println("\n***COMBINATION problem***\nHow many balls in total? ");
        int totalBalls = scanner.nextInt();
        System.out.println("How many balls to choose?");
        int numberOfBallsToChoose = scanner.nextInt();
        System.out.println("You have " + totalBalls + " balls. How many different ways could you choose just "
                + numberOfBallsToChoose + " of them?");
        int result = triangle.howManyWays(totalBalls, numberOfBallsToChoose);

        if (result != PascalTriangle.INVALID_INPUT)
            System.out.println("The answer is: " + result);
        else
            System.out.println("The answer cannot be given with the triangle of size " + triangleSize);
    } // end main
} // end PascalTriangle