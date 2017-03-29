
import java.io.Serializable;
import java.security.InvalidParameterException;

/**
 * Course
 */

public class Course implements Serializable
{
    private String name;
    private String description;
    private String subject;
    private boolean required;
    private int numberOfUnits;
    public static final int MAX_NUMBER_OF_UNITS = 5;
    public static final int MIN_NUMBER_OF_UNITS = 1;

    /**
     * constructor
     *
     * @param name          the course name
     * @param description   the course description
     * @param subject       the subject
     * @param required      is the course required
     * @param numberOfUnits the number of units
     */
    public Course(String name, String description,
                  String subject, boolean required, int numberOfUnits)
    {
        this.name = name;
        this.description = description;
        this.subject = subject;
        this.required = required;
        setNumberOfUnits(numberOfUnits);
    }

    /**
     * accessor method
     *
     * @return the value of instance variable name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * accessor method
     *
     * @return the value of instance variable description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * accessor method
     *
     * @return the value of instance variable subject
     */
    public String getSubject()
    {
        return this.subject;
    }

    /**
     * accessor method
     *
     * @return the value of instance variable required
     */
    public boolean getRequired()
    {
        return this.required;
    }

    /**
     * accessor method
     *
     * @return the value of instance variable  numberOfUnits
     */
    public int getNumberOfUnits()
    {
        return this.numberOfUnits;
    }

    /**
     * mutator method
     *       changes the numberOfUnits if the new value is between min and max number of units
     *       otherwise it throws InvalidParameterException5
     */
    public void setNumberOfUnits(int numberOfUnits) throws InvalidParameterException
    {
        if (numberOfUnits >= MIN_NUMBER_OF_UNITS && numberOfUnits <= MAX_NUMBER_OF_UNITS)
            this.numberOfUnits = numberOfUnits;
        else
            throw new InvalidParameterException("Number of units must be between " + MIN_NUMBER_OF_UNITS + " and " + MAX_NUMBER_OF_UNITS);
    }

    /**
     * toString
     *
     * @return the values of the instance variables
     */
    public String toString()
    {
        return "Course name: " + this.name
               + ", description: \"" + this.description
               + "\", subject: " + this.subject
               + ", required: " + this.required
               + ", number of units:  " + this.numberOfUnits;
    }
}