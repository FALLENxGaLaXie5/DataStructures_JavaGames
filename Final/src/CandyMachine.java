import java.security.InvalidParameterException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * User: Joshua Steward
 * Date: 12/6/14
 */
public class CandyMachine {
    private int[] receipt;
    private CashRegister cashRegister;
    private ArrayList<Item> dispenser;
    public static final int STOP = -1;
    private final DecimalFormat pricePattern = new DecimalFormat("$#0.00");

    public CandyMachine(Scanner fromFile)
    {

        this.dispenser = new ArrayList<Item>();

        this.cashRegister = new CashRegister();

        System.out.println("\nReading inventory from the file:");
        while (fromFile.hasNext())
        {
            String stringRead = fromFile.nextLine();
            Scanner parse = new Scanner(stringRead);
            parse.useDelimiter(",");
            try
            {
                boolean taxable = parse.nextBoolean();
                String name = parse.next();
                double price = parse.nextDouble();
                int numberOfItems = parse.nextInt();

                if (taxable)
                {
                    ItemWithTax tempItem = new ItemWithTax(name, price, numberOfItems);
                    this.dispenser.add(tempItem);
                }
                else
                {
                    ItemNoTax tempItem = new ItemNoTax(name, price, numberOfItems);
                    this.dispenser.add(tempItem);
                }



            }
            catch (InputMismatchException ime)
            {
                System.out.println("Error in item: " + stringRead + "; record ignored.");
            }
            catch (InvalidParameterException ipe)
            {
                System.out.println("Missing data in inventory record: \"" + stringRead + "\"; ignoring");
            }
            catch (NoSuchElementException nee)
            {
                System.out.println("Item does not exist. Ignoring");
            }
        }


        this.receipt = new int [this.dispenser.size()];
        fromFile.close();

        System.out.println("Finished reading the file.\n");

    }

    public void showSelection()
    {
        System.out.println("***Welcome to Anna's Candy Place***");
        System.out.println("To select an item, enter: ");
        System.out.println("0 for Candy @ $4.00 plus sales tax of 7% (inventory of 50)");
        System.out.println("1 for Chips @ $3.00 plus sales tax of 7% (inventory of 2)");
        System.out.println("2 for Gum @ $2.00 no sales tax (inventory of 25)");
        System.out.println("3 for Cookies @ $6.00 plus sales tax of 7% (inventory of 0)");
        System.out.println("4 for Dark Chocolate @ $10.00 no sales tax (inventory of 10)");
        System.out.println("5 for Peppermint Pattie @ $3.00 no sales tax (inventory of 100)");
        System.out.println("-1 to exit");
    }

    public boolean checkInventory(int choice)
    {
        if (choice <=5 && choice >= 0)
        {
            try
            {
                Item tempItem = this.dispenser.get(choice);
                return true;
            }
            catch (NoSuchElementException nee)
            {
                System.out.println("Item does not exist.");
                return false;
            }
        }
        else
        {
            return false;
        }


    }

    public void sellProduct(int choice)
    {
        Item currentChoice = this.dispenser.get(choice);
        double cost = currentChoice.getPrice();
        System.out.println("Please insert " + pricePattern.format(cost));
        cashRegister.addCash(cost);
        currentChoice.decrementNumberOfItems();
        this.receipt[choice]++;

        System.out.println(">>> Collect your item at the bottom tray and enjoy.\n");
    }

    public void printReceipt()
    {
        System.out.println("\n** Receipt **");
        int totalPurchases = 0;

        for (int i = 0; i < this.receipt.length; i++)
        {
            totalPurchases += this.receipt[i];
        }
        System.out.println("You bought " + totalPurchases + " items: ");

        double totalPrice = 0;

        for (int i = 0; i < this.receipt.length; i++)
        {
            if (this.receipt[i] > 0)
            {
                System.out.print(this.receipt[i] + " " + this.dispenser.get(i).toString());
                totalPrice += this.dispenser.get(i).getPrice();
            }
        }

        System.out.println("==============");


        System.out.println("Grand total: " + pricePattern.format(totalPrice));
    }

    public void printInventory()
    {
        System.out.println("\n**** Remaining inventory ****");
        System.out.println("There is " + pricePattern.format(cashRegister.getCashOnHand()) + " in the cash register.");
        System.out.println("Content of the dispenser: ");
        for (Item currentItem : this.dispenser)
        {
            System.out.println(currentItem.getNumberOfItems() + " items of " + currentItem.getName());
        }
    }
}