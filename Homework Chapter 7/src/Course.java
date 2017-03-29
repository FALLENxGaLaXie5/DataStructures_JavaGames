/**
 * Course Class
 * Created by Joshua Steward on 10/13/2014.
 */
public class Course
{
    private String code;
    private String description;
    private int numberOfCredits;

    public Course()
    {
        code = "CS1";
        description = "";
        numberOfCredits = 0;
    }

    public Course(String code,
                  String description,
                  int numberOfCredits)
    {
        if(code.equalsIgnoreCase("CS1") || code.equalsIgnoreCase("CS2")
                || code.equalsIgnoreCase("CS3") || code.equalsIgnoreCase("CS4"))
        {

            this.code = code;
            this.description = description;
            this.numberOfCredits = numberOfCredits;
        }
        else
        {
            System.out.println("Invalid Code!");
        }
    }

    public String getCode()
    {
        return code;
    }

    public String getDescription()
    {
        return description;
    }

    public int getNumberOfCredits()
    {
        return numberOfCredits;
    }

    public void setCode(String code)
    {
        if (code.equalsIgnoreCase("CS1") || code.equalsIgnoreCase("CS2")
                || code.equalsIgnoreCase("CS3") || code.equalsIgnoreCase("CS4"))
        {
            this.code = code;
        }
        else
        {
            System.out.println("Code is invalid!");
        }
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setNumberOfCredits(int numberOfCredits)
    {
        this.numberOfCredits = numberOfCredits;
    }

    public String toString()
    {
        return "Course Code: " + code
                + "\nCourse Description: "
                + description
                + "\nNumber of Credits in Course: " + numberOfCredits;
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof Course))
        {
            return false;
        }
        else
        {
            Course objCourse = (Course) o;
            if ((code.equals(objCourse.code))
                    && (description.equals(objCourse.description))
                    && (numberOfCredits == objCourse.numberOfCredits))
            {
                return true;
            }
            else
            {
                return false;
            }

        }
    }

    public int Business ()
    {
        char num = code.charAt(code.length()-1);
       switch (num)
       {
           case '1':
               return 1;

           case '2':
               return 2;

           case '3':
               return 3;

           case '4':
               return 4;

           default:
               return 0;

       }
    }
}
