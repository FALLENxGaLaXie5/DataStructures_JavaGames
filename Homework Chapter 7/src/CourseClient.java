/**
 * Course Client
 * Created by Joshua Steward on 10/13/2014.
 */
public class CourseClient
{
    public static void main( String [] args)
    {
        Course cour = new Course();
        cour.setCode("CS4");
        cour.setDescription("A great class all about math");
        cour.setNumberOfCredits(4);
        System.out.println(cour.toString());
        System.out.println("Course " + cour.getCode() + " is " + cour.getDescription()
                + ", and is " + cour.getNumberOfCredits() + " credits.");

        Course cour2 = new Course("CS2", "An Awesome English Class", 3);

        if(cour2.getNumberOfCredits() == cour.getNumberOfCredits())
        {
            System.out.println("The last number in course " + cour.getCode()
                    + " is " + cour.Business() + ".");
        }
        else
        {
            System.out.println("The last number in course " + cour2.getCode()
                    + " is " + cour2.Business() + ".");
        }


    }
}
