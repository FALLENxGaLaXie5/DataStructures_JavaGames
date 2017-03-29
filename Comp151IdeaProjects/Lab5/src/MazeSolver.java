import java.util.*;

/**
 * Created by atb on 2/12/15.
 * https://www.cs.bu.edu/teaching/alg/maze/
 */
public class MazeSolver
{
    private char[][] maze;

    public MazeSolver(char[][] grid)
    {
        setMaze(grid);
    }

    public void setMaze(char[][] grid)
    {
        this.maze = new char[grid.length][];
        for (int r = 0; r < grid.length; r++)
        {
            this.maze[r] = new char[grid[r].length];
            for (int c = 0; c < grid[r].length; c++)
                this.maze[r][c] = grid[r][c];
        }
    }

    private boolean findPath(int r, int c)
    {
        System.out.println("IMPLEMENT findPath using recursion");
        return false;
    }

    private boolean isInsideMaze(int r, int c)
    {
        return (r >= 0 && c >= 0 && r < this.maze.length && c < this.maze[0].length);
    }

    private boolean isGoal(int r, int c)
    {
        return (this.maze[r][c] == 'G');
    }

    private boolean isOpen(int r, int c)
    {
        return (this.maze[r][c] == '.' || this.maze[r][c] == 'S');
    }

    private boolean setGoal(int r, int c)
    {
        boolean goalOK = false;
        if (isInsideMaze(r, c) && isOpen(r, c))
        {
            this.maze[r][c] = 'G';
            goalOK = true;
        }
        return goalOK;
    }

    private boolean setStart(int r, int c)
    {
        boolean startOK = false;
        if (isInsideMaze(r, c) && isOpen(r, c))
        {
            this.maze[r][c] = 'S';
            startOK = true;
        }
        return startOK;
    }

    public void displayMaze()
    {
        for (int c = 0; c < this.maze[0].length; c++)
        {
            System.out.printf("[%1$2s] ", c);
        }
        System.out.println();
        for (int r = 0; r < this.maze.length; r++)
        {
            System.out.printf("[%1$2s]", r);
            for (int c = 0; c < this.maze[0].length; c++)
            {
                System.out.printf("%1$5s", this.maze[r][c]);
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        char[][] grid = {{'.', '#', '#', '#', '#', '#'},
                         {'.', '.', '.', '.', '.', '#'},
                         {'#', '.', '#', '#', '#', '#'},
                         {'#', '.', '#', '.', '#', '#'},
                         {'.', '.', '.', '#', '.', '.'},
                         {'#', '#', '.', '.', '.', '#'}};

        MazeSolver searchGrid = new MazeSolver(grid);
        System.out.print("\n        *** SEARCH THE MAZE ***\n      ");
        searchGrid.displayMaze();
        Scanner keyboard = new Scanner(System.in);

        int rGoal;
        int cGoal;
        int rStart;
        int cStart;
        boolean inputOK;
        do
        {
            inputOK = true;
            System.out.println("Enter the GOAL row");
            rGoal = keyboard.nextInt();
            System.out.println("Enter the GOAL column");
            cGoal = keyboard.nextInt();
            if (!searchGrid.setGoal(rGoal, cGoal))
            {
                System.out.println("Incorrect GOAL coordinates, please try again.");
                inputOK = false;
            }
        } while (!inputOK);
        do
        {
            inputOK = true;
            System.out.println("Enter the START row");
            rStart = keyboard.nextInt();
            System.out.println("Enter the START column");
            cStart = keyboard.nextInt();
            if (!searchGrid.setStart(rStart, cStart))
            {
                System.out.println("Incorrect START coordinates, please try again.");
                inputOK = false;
            }
        } while (!inputOK);

        searchGrid.displayMaze();
        if (searchGrid.findPath(rStart, cStart))
            System.out.println("\n---> The GOAL [" + rGoal + "," + cGoal + "] was found!");
        else
            System.out.println("\n---> The GOAL [" + rGoal + "," + cGoal + "]  was not reached!");
        System.out.println("\nThe search results:");
        searchGrid.displayMaze();
    }
}
