import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * User: atb
 * Date: 12/6/14
 */
public class CandyMachineClient
{
    public static void main(String[] args)
    {
        try
        {
            CandyMachine candyMachine = new CandyMachine(new Scanner(new File("inventory.txt")));

            Scanner keyboard = new Scanner(System.in);
            candyMachine.showSelection();
            int choice = keyboard.nextInt();
            while (choice != CandyMachine.STOP)
            {
                if (candyMachine.checkInventory(choice))
                {
                    candyMachine.sellProduct(choice);
                }
                candyMachine.showSelection();
                choice = keyboard.nextInt();
            }

            candyMachine.printReceipt();
            candyMachine.printInventory();
        } catch (FileNotFoundException fnfe)
        {
            System.out.println("Unable to find input file inventory.txt");
        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }//end main
}