import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Joshua Steward on 12/3/2014.
 */
public class CourseOfferings
{
    private ArrayList<Course> offerings;

    //When reading from the file, it the constructor is successfully initializing the respective variables to the parse.next().
    //However, it isn't addings the course right, and is generating the InvalidParamterException in the Course File.

    public CourseOfferings(Scanner input)
    {
        this.offerings = new ArrayList<Course>();
            while (input.hasNext())
            {
                String nextCourse = input.nextLine();
                Scanner parse = new Scanner(nextCourse);
                parse.useDelimiter(";");
                String nextName = parse.next();
                String nextDescription = parse.next();
                String nextSubject = parse.next();
                try
                {
                    boolean nextRequired = parse.nextBoolean();
                    int nextNumberOfUnits = parse.nextInt();
                    Course tempCourse = new Course(nextName, nextDescription
                            ,nextSubject, nextRequired, nextNumberOfUnits );
                    this.offerings.add(tempCourse);
                }
                catch (Exception e)
                {
                    System.out.println("Error in course: " + nextCourse
                            + "; course ignored.");
                }

            }
    }

    public void saveSelectedCourses(String newCourseNames, String file)
    {
        try
        {
            //ArrayList<Course> coursesToAdd = new ArrayList<Course>();
            Scanner parse = new Scanner(newCourseNames);
            parse.useDelimiter(";");
            FileOutputStream fos = new FileOutputStream(file, false);
            ObjectOutputStream oos = new ObjectOutputStream( fos );

            while (parse.hasNext())
            {
                String courseName = parse.next();
                for (Course currentCourse : this.offerings)
                {
                    try
                    {
                        if (courseName.equalsIgnoreCase(currentCourse.getName()))
                        {
                            oos.writeObject(currentCourse);
                            System.out.println("Adding course: " + currentCourse.getName());
                        }
                    }
                    catch (NotSerializableException nse)
                    {
                      System.out.println("Did not serialize.");
                    }
                }
            }
            System.out.println("Your course selection has been added to myCourses.txt");
            oos.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Unable to write to file.");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        //catch (NoSuchElementException nee)
        //{
        //    System.out.println("Element not found.");
        //    nee.printStackTrace();
        //}
    }

    public ArrayList<Course> getAllWithNumOfUnits(int inputUnits)
    {
        ArrayList<Course> allWithNumOfUnits = new ArrayList<Course>();
        for (Course currentCourse: this.offerings)
        {
            if (currentCourse.getNumberOfUnits() == inputUnits)
            {
                allWithNumOfUnits.add(currentCourse);
            }
        }
        return allWithNumOfUnits;
    }

    public Course getCourseWithMostUnits()
    {
        Course currentMostUnits = this.offerings.get(0);
        for (int i = 1; i < this.offerings.size(); i++)
        {
            if (this.offerings.get(i).getNumberOfUnits() > currentMostUnits.getNumberOfUnits())
            {
                currentMostUnits = this.offerings.get(i);
            }
        }
        return currentMostUnits;
    }

    public void display()
    {
        for (Course currentCourse: this.offerings)
        {
            System.out.println("Name: " + currentCourse.getName());
            System.out.println("Description: " + currentCourse.getDescription());
            System.out.println("Subject: " + currentCourse.getSubject());
            System.out.println("Required: " + currentCourse.getRequired());
            System.out.println("Number of units: " + currentCourse.getNumberOfUnits());
            System.out.println();
        }
    }
}
