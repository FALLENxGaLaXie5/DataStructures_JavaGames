/**
 * Created by Joshua on 9/19/2014.
 */

import java.util.Scanner

public class NextPart
{
    public static void main( String [] args )
    {
        Scanner scan = new Scanner( System.in );
        System.out.print("Enter the year here: ");
        int y = scan.nextInt();
        int a = y % 19;
        int b = y/100;
        int c = y % 100;
        int d = y/4;
        int e = y % 4;
        int g = (8 * b + 13)/25;
    }
}
