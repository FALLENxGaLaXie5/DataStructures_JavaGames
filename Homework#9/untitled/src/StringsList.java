

/**
 * Created by Joshua Steward on 11/9/2014.
 */
import java.util.ArrayList;

public class StringsList
{
    private ArrayList<String> stringsList;

    public StringsList()
    {
        stringsList = new ArrayList<String>();
        stringsList.add("hi");
        stringsList.add("no");
        stringsList.add("bye");
        stringsList.add("yo");
        stringsList.add("why");
        stringsList.add("ti");
        stringsList.trimToSize();
    }

    public String toString()
    {
        String result = "";
        for (String current : stringsList)
        {
            result += current + "\n";
        }
        return result;
    }

    public String EvenOrOdd()
    {
        String out = "";
        int count = 0;
        for (String current : stringsList)
        {
            count++;
        }
        if (count % 2 == 0)
        {
            out = "even";
        }
        else
        {
            out = "odd";
        }
        return out;
    }
}
