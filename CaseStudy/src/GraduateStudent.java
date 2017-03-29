/**
 * Created by joshua.steward095 on 11/17/2014.
 */
public class GraduateStudent extends Student
{
    private final int PASSING_GRADE = 80;

    public GraduateStudent(String name)
    {
        super(name);
    }

    public String computeCourseGrade()
    {
        String returnValue;
        if (getTestTotal() / Student.NUM_OF_TESTS >= PASSING_GRADE)
        {
            returnValue = "PASSS";
        }
        else
        {
            returnValue = "NO PASS";
        }
        return returnValue;
    }

    public String toString()
    {
        return "Grad student: " + super.toString();
    }
}
