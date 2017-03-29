import java.text.DecimalFormat;


/**
 * Created by Joshua on 11/24/2014.
 */
public class StudentRecord
{
    private DecimalFormat GPA = new DecimalFormat();
    private String name = "";
    private String id = "";
    private String password = "";
    private double gpa = 0.0;

    public StudentRecord()
    {

    }

    public StudentRecord(String name, String id, String password, double gpa)
    {
        setName(name);
        setId(id);
        setPassword(password);
        setGpa(gpa);
    }

    public String getName()
    {
        return this.name;
    }


    public void setName(String newName)
    {
        this.name = newName;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId (String newId)
    {
        this.id = newId;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String newPassword)
    {
        this.password = newPassword;
    }

    public double getGpa()
    {
        return this.gpa;
    }

    public void setGpa(double newGpa)
    {
        this.gpa = newGpa;
    }

    public String toString()
    {
        return "";
    }
}
