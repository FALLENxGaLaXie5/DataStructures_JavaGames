/**
 * Created by Joshua on 11/14/2014.
 */
public class Employee extends Person
{
    private String officeNum;
    private String salary;
    private String dateHired;
    public Employee()
    {
        super();
        this.officeNum = "";
        this.salary = "";
        this.dateHired = "";
    }
    public Employee(String name, String address, String phone,
                    String email, String newOfficeNum,
                    String newSalary, String newDateHired)
    {
        super(name, address, phone, email);
        setOfficeNum(newOfficeNum);
        setSalary(newSalary);
        setDateHired(newDateHired);
    }

    public String getOfficeNum()
    {
        return this.officeNum;
    }

    public void setOfficeNum(String newOfficeNum)
    {
        this.officeNum = newOfficeNum;
    }

    public String getSalary()
    {
        return this.salary;
    }

    public void setSalary(String newSalary)
    {
        this.salary = newSalary;
    }

    public String getDateHired()
    {
        return this.dateHired;
    }

    public void setDateHired(String newDateHired)
    {
        this.dateHired = newDateHired;
    }

    public String toString()
    {
        return super.toString() + "\nThis employee's office number is "
                + getOfficeNum() + ", they make "
                + getSalary() + " per year, " + ", and they were hired on " + getDateHired();
    }
}
