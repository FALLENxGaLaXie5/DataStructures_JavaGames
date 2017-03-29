/**
 * A class that implements the ADT sorted list by using a chain of linked nodes.
 * Duplicate entries are allowed.
 *
 * @author Joshua Steward
 * @version 3/28/2015
 */
public class SortedListWithMode
{
    private SortedLinkedList<Integer> myList;

    public SortedListWithMode()
    {
        this.myList = new SortedLinkedList<>();
    }

    public void add (Integer element)
    {
        this.myList.add(element);
    }

    public String toString()
    {
        String content = "has " + this.myList.getLength() + " elements: ";
        for (int i = 1; i <= this.myList.getLength(); i++)
        {
            content += this.myList.getEntry(i) + " ";

        }
        return content + "\n";
    }

    // Part a: Using only the public methods of SortedLinkedList,
    // find the mode. The mode is the most frequent value.
    // NOTE - this list is 1 based

    /**
     * sets the mostFrequent Integer to null
     * if myList contains entries
     *      set currentValue to the first entry in list
     *      instantiate nextEntry
     *      set the mostFrequent to currentValue, which is the first entry first
     *      set currentCount to 1
     *      set currentHighestCount to currentCount
     *      for every entries of mylist, from the 2nd entry to the end
     *          set nextEntry to the current iteration
     *          if nextEntry is equal to currentValue
     *              increment currentCount
     *          otherwise,
     *              set currentCount to 1 and currentValue to nextEntry
     *                  if currentCount is greater than currentHighestCount
     *                      set currentHighestCount to currentCount
     *          if the currentcount is greater than the currentHighestCount
     *              set currenthighestCount to currentCount
     *              set mostFrequent to nextEntry
     *
     * @return  mostFrequent (mode)
     */
    public Integer getMode()
    {
        Integer mostFrequent = null;
        if (this.myList.getLength() > 0)
        {
            Integer currentValue = this.myList.getEntry(1);
            Integer nextEntry;
            mostFrequent = currentValue;
            int currentCount = 1;
            int currentHighestCount = currentCount;
            for (int i = 2; i <= this.myList.getLength(); i++)
            {
                nextEntry = this.myList.getEntry(i);
                if (nextEntry.compareTo(currentValue) == 0)
                {
                    currentCount++;
                }
                else
                {
                    currentCount = 1;
                    currentValue = nextEntry;
                    if (currentCount > currentHighestCount)
                    {
                        currentHighestCount = currentCount;
                    }
                }
                if (currentCount > currentHighestCount)
                {
                    currentHighestCount = currentCount;
                    mostFrequent = nextEntry;
                }
            }
        }
        return mostFrequent;
    } // end getMode


    public static void main(String args[])
    {
        SortedListWithMode tester = new SortedListWithMode();
        tester.add(0);
        System.out.print("\nThe data " + tester);
        System.out.println("The mode should be 0, got: " + tester.getMode());

        for (int i = 1; i < 10; i++)
            tester.add(i);
        System.out.print("\nThe data " + tester);
        System.out.println("The mode should be 0, got: " + tester.getMode());

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < i; j++)
                tester.add(i);
        System.out.print("\nThe data " + tester);
        System.out.println("The mode should be 9, got: " + tester.getMode());

        for (int i = 0; i < 21; i++)
            for (int j = 8; j < i; j++)
                tester.add(i);
        System.out.print("\nThe data " + tester);
        System.out.println("The mode should be 20, got: " + tester.getMode());

        for (int i = 0; i < 14; i++)
            tester.add(6);
        System.out.print("\nThe data " + tester);
        System.out.println("The mode should be 6, got: " + tester.getMode());
    } // end main

/*
The mode should be 0, got: 0
The mode should be 0, got: 0
The mode should be 9, got: 9
The mode should be 20, got: 20
The mode should be 6, got: 6
*/
}
