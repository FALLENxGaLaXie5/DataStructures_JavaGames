/**
 * Created by joshua.steward095 on 11/17/2014.
 */
public class UndergraduateStudent extends Student
{
    private final int PASSING_GRADE = 70;

    public UndergraduateStudent (String name)
    {
        super(name);
    }

    public String computeCourseGrade()
    {
        String returnValue;

        if (getTestTotal() / Student.NUM_OF_TESTS >= PASSING_GRADE)
        {
            returnValue = "PASS";
        }
        else
        {
            returnValue = "NO PASS";
        }
        return returnValue;
    }

    public String toString()
    {
        return "Undergrad student: " + super.toString();
    }
}
