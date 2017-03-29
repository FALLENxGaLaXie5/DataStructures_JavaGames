import java.util.Stack;

/**
 * This class will be used to keep track of the maze.
 *
 * @author Anna Bieszczad
 * @version 02/07/2015
 */

public class Maze
{
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int SCHEDULED = 2;
    private static final int VISITED = 3;


    private int squares[][];
    private int goalRow;
    private int goalCol;
    private Stack<MazeFrame> path;


    public Maze(int[][] maze)
    {
        this.path = new Stack<>();
        this.squares = new int[maze.length][maze[0].length];

        // Convert any non zero values to WALL, zeros will be EMPTY
        // Set goal to the last EMPTY square as the default
        for (int r = 0; r < this.squares.length; r++)
        {
            for (int c = 0; c < this.squares[0].length; c++)
            {
                if (maze[r][c] != 0)
                    this.squares[r][c] = WALL;
                else
                {
                    this.squares[r][c] = EMPTY;
                    this.goalRow = r;
                    this.goalCol = c;
                }
            }
        }
    }

    /**
     * set the goal square
     *
     * @param r the row coordinate of the square.
     * @param c the column coordinate of the square.
     */
    public void setGoal(int r, int c)
    {
        if (isLegal(r, c) && isFree(r, c))
        {
            this.goalRow = r;
            this.goalCol = c;
        }
        System.out.println("Goal is set to: [" + this.goalRow + "," + this.goalCol + "]");
    }

    /**
     * determine if a square is a legal square
     *
     * @param r the row coordinate of the square.
     * @param c the column coordinate of the square.
     * @return true if the square coordinates are within the array for the maze
     */
    public boolean isLegal(int r, int c)
    {
        System.out.println("isLegal - IMPLEMENT ME");
        return false;   //THIS IS A STUB
    }

    /**
     * determine if the square is free to be visited
     *
     * @param r the row coordinate of the square.
     * @param c the column coordinate of the square.
     * @return true if the square is legal and empty
     */
    public boolean isFree(int r, int c)
    {
        System.out.println("isFree - IMPLEMENT ME");
        return false;   //THIS IS A STUB
    }

    /**
     * Visit a square: if the square is legal mark the square VISITED
     * and add the square to the path
     *
     * @param r the row coordinate of the square.
     * @param c the column coordinate of the square.
     */
    public void visitSquare(int r, int c)
    {
        System.out.println("visitSquare - IMPLEMENT ME");

    }

    /**
     * If the square is legal indicate that a square has been SCHEDULED to be visited
     *
     * @param r the row coordinate of the square.
     * @param c the column coordinate of the square.
     */
    public void scheduleSquare(int r, int c)
    {
        System.out.println("scheduleSquare - IMPLEMENT ME");

    }

    /**
     * If the square is legal determine if the square is the goal
     *
     * @param r the row coordinate of the square.
     * @param c the column coordinate of the square.
     * @return true if the square is the goal
     */
    public boolean isGoal(int r, int c)
    {
        System.out.println("isGoal - IMPLEMENT ME");
        return false;   //THIS IS A STUB
    }


    /**
     * search the maze
     *
     * @param startRow the starting row for the search
     * @param startCol the starting col for the search
     * @return true if the goal was found
     */
    public boolean searchMaze(int startRow, int startCol)
    {
        boolean result = false;

        Stack<MazeFrame> localStack = new Stack<>();
        MazeFrame initial = new MazeFrame(startRow, startCol);
        MazeFrame current, up, down, right, left;

        localStack.push(initial);
        System.out.println("searchMaze - IMPLENT ME");
        // visit the current square

        // check if it is not a goal

        // if not a goal schedule visits for the four neighbors

        return result;
    } // end searchMaze

    public void displayMaze()
    {
        System.out.print("      ");
        for (int c = 0; c < this.squares[0].length; c++)
        {
            System.out.printf("[%1$2s] ", c);
        }
        System.out.println();
        for (int r = 0; r < this.squares.length; r++)
        {
            System.out.printf("[%1$2s]", r);
            for (int c = 0; c < this.squares[0].length; c++)
            {
                System.out.printf("%1$5s", this.squares[r][c]);
            }
            System.out.println();
        }
    }

    public void displayPath()
    {
        System.out.println("\n---> The current states:");
        displayMaze();
        System.out.println("The search path is:");
        while (!this.path.empty())
        {
            System.out.print(this.path.pop() + " ");
        }
        System.out.println();
    }

    private class MazeFrame
    {
        private int row;
        private int col;

        public MazeFrame(int r, int c)
        {
            row = r;
            col = c;
        }

        public String toString()
        {
            return "[" + row + "," + col + "]";
        }
    }
}