/**
 * Created by Joshua Steward on 1/22/2015.
 */
import java.util.Random;
public class PiggyBank
{
    private BagInterface<Money> piggyBank;
    private int capacity;

    public PiggyBank(int newCapacity, int numOfMoniesToBeAdded)
    {
        this.capacity = newCapacity;
        this.piggyBank = new ResizableArrayBag<Money>(this.capacity);
        Random random = new Random();



       for (int i = 0; i < numOfMoniesToBeAdded; i++)
        {
            if (random.nextBoolean())
            {
                Coin currentCoin = new Coin();
                this.piggyBank.add(currentCoin);
                System.out.println("Added " + currentCoin.getValue() + " to your piggy bank");
            }
            else
            {
                Bill currentBill = new Bill();
                this.piggyBank.add(currentBill);
                System.out.println("Added " + currentBill.getValue() + " to your piggy bank");
            }
        }

    }



    public void add(Money moniez) throws PiggyBankFullException
    {
        if (!isFull())
        {
            this.piggyBank.add(moniez);
            System.out.println("Added " + moniez.getValue() + " to your piggy bank");
        }
        else
        {
            throw new PiggyBankFullException("Piggy Bank Full; record not added");
        }
    }

    public Money remove()
    {
        Money moniez = this.piggyBank.remove();
        return moniez;
    }

    public boolean isEmpty()
    {
        boolean answer = this.piggyBank.isEmpty();
        return answer;
    }

    public boolean isFull()
    {
        boolean answer = this.piggyBank.isFull();
        return answer;
    }

    public int getCapacity()
    {
        return this.capacity;
    }

    public int emptyAndCountHeads()
    {
        int countHeads = 0;
        while (!isEmpty())
        {
            Money currentMoney = remove();
            if (currentMoney.isHeads())
            {
                countHeads++;
            }
        }
        return countHeads;
    }

    public String toString()
    {
        return "";
    }
}
