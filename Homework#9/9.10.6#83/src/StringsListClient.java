/**
 * Created by Joshua Steward on 11/9/2014.
 */

public class SumOfListClient
{
    public static void main( String [] args )
    {
        StringsList newStrings = new StringsList();
        System.out.println("The list: ");
        System.out.println(newStrings.toString());
        System.out.println("This list has an " + newStrings.EvenOrOdd());
    }
}
