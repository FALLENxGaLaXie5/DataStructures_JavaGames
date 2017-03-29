import java.util.Random;
import java.util.Scanner;

/**
 * MaxSumInRectangularGrid class
 *
 * @author YOUR NAME
 * @version 02/12/2015
 */

public class MaxSumInRectangularGrid
{
    private int[][] grid;
    private int[][] path;
    private final int FROM_ABOVE_LEFT = -1;
    private final int FROM_ABOVE_CENTER = 0;
    private final int FROM_ABOVE_RIGHT = 1;
    private int columnIndexMaxSum;

    /**
     * Secondary constructor
     *
     * @param inputGrid the array of numbers
     */
    public MaxSumInRectangularGrid(int[][] inputGrid)
    {
        setGrid(inputGrid);
    }

    /**
     * Mutator method:<BR>
     * Allows client to set values of numbers
     * <B>setGrid</B> sets the values
     * in <B>grid</B> to the values in newGrid
     *
     * @param newGrid the new int array for numbers
     */
    public void setGrid(int[][] newGrid)
    {
        this.grid = new int[newGrid.length][];
        this.path = new int[newGrid.length][];
        for (int r = 0; r < newGrid.length; r++)
        {
            this.grid[r] = new int[newGrid[r].length];
            this.path[r] = new int[newGrid[r].length];
            for (int c = 0; c < newGrid[r].length; c++)
                this.grid[r][c] = newGrid[r][c];
        }
    }

    /**
     * getGrid method
     *
     * @return the array of numbers
     */
    public int[][] getGrid()
    {
        int[][] temp = new int[this.grid.length][];
        for (int r = 0; r < this.grid.length; r++)
        {
            temp[r] = new int[this.grid[r].length];
            for (int c = 0; c < this.grid[r].length; c++)
                temp[r][c] = this.grid[r][c];
        }
        return temp;
    }

    /**
     * toString
     *
     * @return the grid as a String organized as a rectangle
     */
    public String toString()
    {
        String result = "";
        for (int r = 0; r < this.grid.length; r++)
        {
            for (int c = 0; c < this.grid[r].length; c++)
                result += this.grid[r][c] + "\t";
            result += "\n";
        }
        return result;
    }

    /**
     * equals
     *
     * @param o MaxSumInRectangularGrid object
     * @return return true if the grid in other is equal to
     *         the grid in this object
     */
    public boolean equals(Object o)
    {
        boolean same = true;
        if (!(o instanceof MaxSumInRectangularGrid))
            same = false;
        else
        {
            MaxSumInRectangularGrid other = (MaxSumInRectangularGrid) o;

            same = (this.grid.length != other.grid.length);
            for (int r = 0; r < this.grid.length && same; r++)
            {
                same = (this.grid[r].length != other.grid[r].length);
                for (int c = 0; c < this.grid[r].length && same; c++)
                {
                    if (this.grid[r][c] != other.grid[r][c])
                        same = false;
                }
            }
        }
        return same;
    }

    /**
     * maxSum method
     * computes the maximum sum for a legal path
     *
     * @return returns an int, the maximum sum for a legal path
     */
    public int maxSum()
    {
        // starting with the last row
        int sum = maxSum(this.grid.length - 1, 0);
        this.columnIndexMaxSum = 0;
        for (int c = 1; c < this.grid[0].length; c++)
        {
            if (maxSum(this.grid.length - 1, c) > sum)
            {
                this.columnIndexMaxSum = c;
                sum = maxSum(this.grid.length - 1, c);
            }
        }
        return sum;
    }

    /**
     * private maxSum method
     * computes the maximum sum for a legal path
     *
     * @param r int representing the row index
     * @param c int representing the column index
     * @return returns an int, the maximum sum for a legal path
     */
    private int maxSum(int r, int c)
    {
        if (r == 0)                                       // base case # 1, first row
            return this.grid[r][c];
        else if (c == 0 && c == this.grid[r].length - 1)      // general case # 1, one column only
        {
            this.path[r][c] = FROM_ABOVE_CENTER;
            return (this.grid[r][c] + maxSum(r - 1, c));
        }
        else if (c == 0)                                  // general case # 2, left side
        {
            if (maxSum(r - 1, c) >= maxSum(r - 1, c + 1))
            {
                this.path[r][c] = FROM_ABOVE_CENTER;
                return (this.grid[r][c] + maxSum(r - 1, c));
            }
            else
            {
                this.path[r][c] = FROM_ABOVE_RIGHT;
                return (this.grid[r][c] + maxSum(r - 1, c + 1));
            }
        }
        else if (c == this.grid[r].length - 1)             // general case # 3, right side
        {
            if (maxSum(r - 1, c) >= maxSum(r - 1, c - 1))
            {
                this.path[r][c] = FROM_ABOVE_CENTER;
                return (this.grid[r][c] + maxSum(r - 1, c));
            }
            else
            {
                this.path[r][c] = FROM_ABOVE_LEFT;
                return (this.grid[r][c] + maxSum(r - 1, c - 1));
            }
        }
        else                                                 // general case # 4, middle
        {
            if (maxSum(r - 1, c) >= maxSum(r - 1, c - 1) &&
                    maxSum(r - 1, c) >= maxSum(r - 1, c + 1))
            {
                this.path[r][c] = FROM_ABOVE_CENTER;
                return (this.grid[r][c] + maxSum(r - 1, c));
            }
            else if (maxSum(r - 1, c - 1) > maxSum(r - 1, c) &&
                    maxSum(r - 1, c - 1) >= maxSum(r - 1, c + 1))
            {
                this.path[r][c] = FROM_ABOVE_LEFT;
                return (this.grid[r][c] + maxSum(r - 1, c - 1));
            }
            else
            {
                this.path[r][c] = FROM_ABOVE_RIGHT;
                return (this.grid[r][c] + maxSum(r - 1, c + 1));
            }
        }
    }

    /**
     * maxPath method
     * prepares the String representation of the path for the maximum sum
     *
     * @return returns a String, the path for the maximum sum
     */
    public String maxPath()
    {
        return maxPath(this.grid.length - 1, this.columnIndexMaxSum);
    }

    /**
     * private maxPath method
     * prepares the String representation of the path for the maximum sum
     * based on the information set in this.path;
     * makes recursive calls based on where the current was reached from:
     * FROM_ABOVE_LEFT
     * FROM_ABOVE_CENTER
     * FROM_ABOVE_RIGHT
     *
     * @param r int representing the row index
     * @param c int representing the column index
     * @return returns a String, the path for the maximum sum
     */
    private String maxPath(int r, int c)
    {
        return "TO BE IMPLEMENTED";
    }

    public static void main(String[] args)
    {
        final int MAX_NUMBER = 25;
        Scanner scan = new Scanner(System.in);

        // Get user input for the rectangle
        int rows;
        do
        {
            System.out.print("Enter the number of rows of the grid (between 1 and 10) > ");
            rows = scan.nextInt();
        } while (rows <= 0 || rows > 10);

        int columns;
        do
        {
            System.out.print("Enter the number of columns of the grid (between 1 and 20) > ");
            columns = scan.nextInt();
        } while (columns <= 0 || columns > 20);

        // Fill the grid with numbers
        int[][] values = new int[rows][columns];
        Random random = new Random();
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < columns; c++)
            {
                values[r][c] = random.nextInt(MAX_NUMBER) + 1;
            }
        }

        // Declare and instantiate MaxSumInRectangularGrid object
        MaxSumInRectangularGrid rg = new MaxSumInRectangularGrid(values);
        System.out.println("\n" + rg);

        System.out.println("\nThe max sum is " + rg.maxSum());

        System.out.println("The max path is " + rg.maxPath());
    }
}