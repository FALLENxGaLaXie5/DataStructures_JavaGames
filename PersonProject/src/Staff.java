/**
 * Created by Joshua on 11/14/2014.
 */
public class Staff extends Employee
{
    private String title;
    public Staff()
    {
        super();
        this.title = "";
    }
    public Staff(String name, String address,
                 String phone, String email, String officeNum,
                 String salary, String dateHired,String newTitle)
    {
        super(name, address, phone, email, officeNum, salary, dateHired);
        setTitle(newTitle);
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String newTitle)
    {
        this.title = newTitle;
    }

    public String toString ()
    {
        return super.toString() + "This staff member is a " + getTitle() + ".";
    }
}
