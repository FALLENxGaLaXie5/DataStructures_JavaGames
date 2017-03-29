/**
 * Average, Min, and Max grade calculator
 * Created by Joshua Steward on 10/2/2014.
 */

//Algorithm:
//
//      Declare variable minGrade and initialize it to Integer.MAX_VALUE
//      Declare variable maxGrade and initialize it to Integer.MIN_VALUE
//      Use a for loop to get 5 values. Inside the for loop:
//          use a do-while loop to make sure that each entered value is in the correct range.
//          Calculate requested minimum, maximum, and the running total as the values of grades are entered
//      When outside of the for loop calculate the requested average
//      Display the results


import java.util.Scanner;

public class AverageGrades
{
    public static void main( String [] args)
    {
        Scanner scan = new Scanner( System.in );
        int minGrade = Integer.MAX_VALUE;
        int maxGrade = Integer.MIN_VALUE;
        int i = 0;
        int grade = 0;
        int total = 0;

        for (i = 1; i < 6; i ++)
        {


            do
            {
                System.out.print("Enter grade " + i + " > ");
                grade = scan.nextInt();
            }while (!(grade <= 100 && grade >= 0));

            if (minGrade > grade)
            {
                minGrade = grade;
            }
            else if (maxGrade < grade)
            {
                maxGrade = grade;
            }

            total = total + grade;

        }
        double average = (double)total/5;
        System.out.println("The average grade is "
                + average + ", the minimum grade is "
                + minGrade + ", and the maximum grade is "
                + maxGrade + ".");

    }
}
