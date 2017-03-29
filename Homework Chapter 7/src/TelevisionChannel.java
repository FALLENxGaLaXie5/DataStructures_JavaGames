/**
 * Television Channel Class
 * Created by Joshua Steward on 10/12/2014.
 */
public class TelevisionChannel
{
    private String name;
    private int number;
    private boolean cable;

    public TelevisionChannel()
    {
        name = "";
        number = 0;
        cable = false;
    }

    public TelevisionChannel(String startName,
                             int startNumber,
                             boolean startCable)
    {
        name = startName;
        number = startNumber;
        cable = startCable;
    }

    public String getName()
    {
        return name;
    }

    public int getNumber()
    {
        return number;
    }

    public boolean getCable()
    {
        return cable;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setNumber(int newNumber)
    {
        if ( newNumber > 0 && newNumber < 1000)
        {
            number = newNumber;
        }
        else
        {
            System.err.println("Channel must be greater than 0 and less than 1000. Channel has not been changed. ");
        }


    }
    public void setCable(boolean newCable)
    {
        cable = newCable;
    }

    public int numOfDigits(int number)
    {
        if(number < 10)
        {
            return 1;
        }
        else if (number < 100)
        {
            return 2;
        }
        else if (number < 1000)
        {
            return 3;
        }
        else
        {
            return 0;
        }

    }

    public String toString()
    {
        return "Channel Name: " + name
                + "\nChannel Number: "
                + number
                + "\nCable: " + cable;
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof TelevisionChannel))
        {
            return false;
        }
        else
        {
            TelevisionChannel objTel = (TelevisionChannel) o;
            if ((name.equals(objTel.name))
                    && (number == objTel.number)
                    && (((cable) && (objTel.cable))
                    || (!(cable) && !(objTel.cable))))
            {
                return true;
            }
            else
            {
                return false;
            }

        }
    }

    public String isCable()
    {
        if(cable)
        {
            return "cable";
        }
        else
        {
            return "network";
        }
    }
}
