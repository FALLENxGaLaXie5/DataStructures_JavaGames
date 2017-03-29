/**
 * Created by Joshua on 11/14/2014.
 */
public class Person
{
    private String name;
    private String address;
    private String phone;
    private String email;

    public Person()
    {
        this.name = "";
        this.address = "";
        this.phone = "";
        this.email = "";
    }

    public Person(String newName, String newAddress, String newPhone, String newEmail)
    {
        setName(newName);
        setAddress(newAddress);
        setPhone(newPhone);
        setEmail(newEmail);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName (String newName)
    {
        this.name = newName;
    }

    public String getAddress()
    {
       return this.address;
    }

    public void setAddress (String newAddress)
    {
        this.address = newAddress;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String newPhone)
    {
        this.phone = newPhone;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String newEmail)
    {
        this.email = newEmail;
    }

    public String toString()
    {
        return  "Person's name is " + getName() + ", their address is "
                + getAddress() + ", their phone number is "
                + getPhone() + ", and their email is " + getEmail() + ".";
    }
}
