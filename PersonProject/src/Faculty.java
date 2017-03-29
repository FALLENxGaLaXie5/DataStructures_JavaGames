/**
 * Created by Joshua on 11/14/2014.
 */
public class Faculty extends Employee
{
    private String officeHours;
    private String rank;
    public Faculty()
    {
        super();
        this.officeHours = "";
        this.rank = "";
    }
    public Faculty(String name, String address,
                   String phone, String email, String officeNum,
                   String salary, String dateHired, String newOfficeHours, String newRank)
    {
        super(name, address, phone, email, officeNum, salary, dateHired);
        setOfficeHours(newOfficeHours);
        setRank(newRank);
    }

    public String getOfficeHours()
    {
        return this.officeHours;
    }

    public void setOfficeHours(String newOfficeHours)
    {
        this.officeHours = newOfficeHours;
    }

    public String getRank()
    {
        return this.rank;
    }

    public void setRank(String newRank)
    {
        this.rank = newRank;
    }

    public String toString ()
    {
        return super.toString() + "\nThis faculty member's office hours are "
                + getOfficeHours() + ", and they are a " + getRank() + ".";
    }
}
