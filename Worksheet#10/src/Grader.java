/**
 * Created by Joshua Steward on 11/7/2014.
 */
import java.util.*;
public class Grader
{
    private final char [] theKey = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A','D'};
    private int [][] theGrades;


    public Grader(int numberofStudents)
    {
        generateTheGrades(numberofStudents);
    }

    public void generateTheGrades (int numOfStudents)
    {
        Random random = new Random();
        this.theGrades = new int[numOfStudents][this.theKey.length];
        for (int r = 0; r < this.theGrades.length; r++)
        {
            for (int c = 0; c < this.theGrades[r].length; c++)
            {
                this.theGrades[r][c] = random.nextInt(4) + 1;
            }
        }
    }



    public void checkGrades()
    {
        char letter;
        for (int r = 0; r < this.theGrades.length; r++)
        {
            int count = 0;
            for (int c = 0; c < this.theGrades[r].length; c++)
            {
                int currentnum = this.theGrades[r][c];
                switch (currentnum)
                {
                    case 1:
                        letter = 'A';
                        break;
                    case 2:
                        letter = 'B';
                        break;
                    case 3:
                        letter = 'C';
                        break;
                    case 4:
                        letter = 'D';
                        break;
                    default:
                        letter = 'A';
                }
                if (letter == this.theKey[c])
                {
                    count ++;
                }
            }
            System.out.println("Student " + r + " got " + count + " correct.");
        }

    }
}
