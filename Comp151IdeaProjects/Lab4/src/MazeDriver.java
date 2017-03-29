/**
 * Maze Driver
 *
 * @author Anna Bieszczad
 * @version 02/07/2015
 */

import java.io.*;
import java.util.*;

public class MazeDriver
{
    public static void main(String args[])
    {
        MazeDriver driver = new MazeDriver();
        String mazeFileName = "maze2.txt";
        boolean anotherMaze = true;
        try
        {
            int[][] mazeArray = driver.readFromFile(mazeFileName);
            Scanner keyboard = new Scanner(System.in);

            String input;
            int startRow;
            do
            {
                Maze maze = new Maze(mazeArray);
                System.out.println("\n\n           *** SOLVE THE MAZE ***");
                maze.displayMaze();

                do
                {
                    System.out.println("Enter start row, start column, goal row and goal column, or stop");
                    input = keyboard.nextLine();
                } while (!input.matches("(\\d+ \\d+ \\d+ \\d+|stop)"));
                if (!input.equals("stop"))
                {
                    Scanner line = new Scanner(input);
                    startRow = line.nextInt();
                    if (startRow >= 0)
                    {
                        int startCol = line.nextInt();
                        int goalRow = line.nextInt();
                        int goalCol = line.nextInt();
                        if (startRow < mazeArray.length && startCol < mazeArray[0].length && startCol >= 0)
                        {
                            maze.setGoal(goalRow, goalCol);
                            boolean goalFound = maze.searchMaze(startRow, startCol);
                            System.out.println("The goal was " + (goalFound ? "" : "not ") + "found!");
                            maze.displayPath();
                        }
                        else
                        {
                            System.out.println("Invalid input, please enter again");
                        }
                    }
                }
                else
                {
                    System.out.println("Bye!");
                    anotherMaze = false;
                }
            } while (anotherMaze);
        }
        catch (IOException e)
        {
            System.out.println("There was an error in reading or opening the file: " + mazeFileName);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Non integer was encountered in the file: " + mazeFileName);
        }
    }

    private int[][] readFromFile(String mazeFileName) throws IOException
    {
        Scanner fromFile = new Scanner(new File(mazeFileName));
        Scanner line = new Scanner(fromFile.nextLine());
        // Expect number of rows and columns of data
        int rows = line.nextInt();
        int cols = line.nextInt();

        int[][] mazeArray = new int[rows][cols];
        // Read the data row by row
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                if (!line.hasNext())
                {
                    line = new Scanner(fromFile.nextLine());
                }
                mazeArray[r][c] = line.nextInt();
            }
        }
        return mazeArray;
    }
}