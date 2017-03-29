/**
 * Created by joshua.steward095 on 1/22/2015.
 */
import java.util.Scanner;
public class CountHeadsGame
{
    public static void main(String[] args)
    {
        int capacity = 0;
        int numToBeAdded = 0;
        do
        {


            Scanner scan = new Scanner(System.in);
            System.out.println("How many coins/bills can fit in your piggy bank?");
            capacity = scan.nextInt();
            System.out.println("How many coins/bills should we add to the piggy bank?");
            numToBeAdded = scan.nextInt();
        }
        while (numToBeAdded > capacity);

        int userHeads = 0;
        int compHeads = 0;
        int turns = 0;
        while (turns < 2)
        {

            if (turns == 0)
            {
                System.out.println("USER'S TURN");
            }
            else
            {
                System.out.println("Computer's TURN");
            }
            PiggyBank piggyBank = new PiggyBank(capacity, numToBeAdded);
            System.out.print(piggyBank);
            try {
                piggyBank.add(new Coin());
                piggyBank.add(new Bill());
            } catch (PiggyBankFullException pfe) {
                System.out.println("PiggyBank is full: record ignored.");
            }

            int heads = piggyBank.emptyAndCountHeads();
            if (turns ==0)
            {
                userHeads = heads;
            }
            else
            {
                compHeads = heads;
            }
            System.out.println(heads + " out of " + piggyBank.getCapacity() + " coins/bills landed HEADS");
            turns++;
        }

        if (userHeads > compHeads)
        {
            System.out.println("User has more heads. WINNER");
        }
        else
        {
            System.out.println("Computer has more heads. WINNER");
        }

    }
}
