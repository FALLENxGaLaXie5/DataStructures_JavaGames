import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by joshua.steward095 on 11/17/2014.
 */
public abstract class Student
{
    public final static int NUM_OF_TESTS = 3;
    private String name;
    private int[] test;
    private String courseGrade;

    public Student()
    {
        this.name = "No Name";
    }

    public Student(String studentName)
    {
        this.name = studentName;
        this.test = new int[NUM_OF_TESTS];
        this.courseGrade = "****";
    }

    public String getCourseGrade()
    {
        return this.courseGrade;
    }

    public void setCourseGrade()
    {
        this.courseGrade = computeCourseGrade();
    }

    public abstract String computeCourseGrade();

    public String getName()
    {
        return this.name;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public int getTestScore(int testNumber)
    {
        return this.test[testNumber - 1];
    }

    public void setTestScore(int testNumber, int testScore)
    {
        this.test[testNumber - 1] = testScore;
    }

    public int getTestTotal()
    {
        int total = 0;
        for (int i = 0; i < this.NUM_OF_TESTS; i++)
        {
            total += this.test[i];
        }
        return total;
    }

    public String toString()
    {
        DecimalFormat df = new DecimalFormat("#0.00");
        return getName() + " scored " + Arrays.toString(this.test)
                + " which is "
                + df.format((double ) getTestTotal() / Student.NUM_OF_TESTS)
                + "% = " + getCourseGrade();
    }
}
