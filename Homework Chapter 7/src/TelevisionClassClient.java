/**
 * Television Channel Executor
 * Created by Joshua Steward on 10/12/2014.
 */
import java.util.Scanner;
public class TelevisionClassClient
{
    public static void main( String [] args )
    {
        //String answer = "";
        Scanner scan = new Scanner( System.in );


            System.out.print("Please enter channel name here: ");
            String name = scan.nextLine();
            System.out.print("Please enter channel number here: ");
            int number = scan.nextInt();
            System.out.print("Please enter whether it is cable or not (true/false): ");
            boolean cable = scan.nextBoolean();

            TelevisionChannel tv = new TelevisionChannel(name, number, cable);

            String name1 = tv.getName();
            int num1 = tv.getNumber();
            boolean cableInitial = tv.getCable();



            System.out.println("On your channel, " + name1 + ", the channel number is "
                    + num1 + ", and it is " + cableInitial + " that it is cable. It also has "
                    + tv.numOfDigits(tv.getNumber()) + " number of digits.");


            tv.setName("Disney Channel");
            tv.setNumber(11);
            tv.setCable(true);
            System.out.println("We are changing the channel to " + tv.getName()
                    + ", which is on channel "
                    + tv.getNumber()
                    + ", and it is " + tv.getCable() + " that it is cable.");
            System.out.println("Channel " + tv.getNumber()
                    + " has " + tv.numOfDigits(tv.getNumber()) + " digits.");
            System.out.println(tv.toString());

            System.out.println(tv.getName() + " is " + tv.isCable() + ".");

            System.out.println("It is " + name1.equals(tv.getName())
                    + " that the previous channel, " + name1 + " equals " + tv.getName() + ".");


    }
}
