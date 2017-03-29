import java.util.Random;

/**
 * Created by Joshua on 10/24/2014.
 */
public class Tester
{
    public static void main( String [] args )
    {
        for (int i = 0; i < 20; i++)
        {
            Random random = new Random();
            int number = random.nextInt(5) + 5;
            System.out.println(number);
        }
    }
}
