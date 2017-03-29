/**
 * Created by Joshua on 11/14/2014.
 */
public class Student extends Person
{
    private String status;
    public Student()
    {
        super();
        this.status = "";
    }
    public Student(String name, String address, String phone, String email, String newStatus)
    {
        super(name, address, phone, email);
        setStatus(newStatus);
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String newStatus)
    {
        this.status = newStatus;
    }

    public String toString()
    {
        return super.toString() + "\nThey are a " + getStatus() + " student.";
    }
}
