/**
 * Created by Joshua on 11/7/2014.
 */
import java.util.Scanner;
public class GraderClient
{
    public static void main( String [] args )
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("Enter number of students: ");
        int students = scan.nextInt();

        Grader grader = new Grader(students);
        grader.checkGrades();
    }
}
