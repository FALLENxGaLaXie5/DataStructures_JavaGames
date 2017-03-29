
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CourseScheduleClient
{
    public static void main(String[] args)
    {
        boolean goodInput = false;
        int requestedNumberOfUnits = 0;
        try
        {
            CourseOfferings courseOfferings = new CourseOfferings(new Scanner(new File("courses.txt")));
            courseOfferings.display();

            Scanner keyboard = new Scanner(System.in);
            do
            {
                try
                {
                    System.out.println("Enter the number of units:");
                    requestedNumberOfUnits = keyboard.nextInt();
                    if (requestedNumberOfUnits < Course.MIN_NUMBER_OF_UNITS
                        || requestedNumberOfUnits > Course.MAX_NUMBER_OF_UNITS)
                        throw new InvalidParameterException("The number of units must be an integer between "
                                                            + Course.MIN_NUMBER_OF_UNITS + " and " + Course.MAX_NUMBER_OF_UNITS);

                    goodInput = true;
                }
                catch (InputMismatchException ime)
                {
                    System.out.println("Error: incompatible data: " + keyboard.nextLine());
                }
                catch (InvalidParameterException ipe)
                {
                    System.out.println("Error: " + ipe.getMessage());
                }
            } while (!goodInput);

            ArrayList<Course> result = courseOfferings.getAllWithNumOfUnits(requestedNumberOfUnits);
            if (result.size() > 0)
            {
                System.out.println("The following courses have " + requestedNumberOfUnits + " units:");
                for (Course course : result)
                {
                    System.out.println(course);
                }
                System.out.println();
            }
            else
            {
                System.out.println("None of the courses have " + requestedNumberOfUnits + " units.");
            }

            keyboard = new Scanner(System.in);
            System.out.println("Enter your course selection (course names separated by ;)");
            courseOfferings.saveSelectedCourses(keyboard.nextLine(), "myCourses.txt");
            System.out.println("The course with the most units in the collection is: \"" + courseOfferings.getCourseWithMostUnits().getName() + "\"");
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Unable to find input file");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}