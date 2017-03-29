import java.util.Arrays;

/**
 * A class that implements the ADT sorted list by using a resizable array.
 * Duplicate entries are allowed.
 *
 * @author Joshua Steward
 * @author Charles Hoot, Frank M. Carrano
 * @version 3/28/2015
 */
public class SortedArrayListWithMode
        <T extends Comparable<? super T>>
{
    private T[] list;                         // array of list entries
    private int numberOfEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;     // initial numberOfEntries of list

    public SortedArrayListWithMode()
    {
        this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor

    public SortedArrayListWithMode(int initialCapacity)
    {
        this.numberOfEntries = 0;
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Comparable[initialCapacity];
        this.list = tempList;
    } // end default constructor



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
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    public T getMode()
    {
        T mostFrequent = null;
        if (this.numberOfEntries > 0)
        {
            T currentValue = this.list[0];
            T nextEntry;
            mostFrequent = currentValue;
            int currentCount = 1;
            int currentHighestCount = currentCount;
            for (int i = 1; i < this.numberOfEntries; i++)
            {
                nextEntry = this.list[i];
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

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void add(T newEntry)
    {
        ensureCapacity();

        int toIndex, fromIndex;

        // beginning at the end of the array, shift entries to next higher position
        // until proper sorted position for newEntry is found
        for (fromIndex = this.numberOfEntries - 1, toIndex = fromIndex + 1;
             (fromIndex >= 0) && (newEntry.compareTo(this.list[fromIndex]) < 0);
             toIndex--, fromIndex--)
        {
            this.list[toIndex] = this.list[fromIndex];
        } // end for

        this.list[toIndex] = newEntry;
        this.numberOfEntries++;
    } // end add

    public boolean remove(T anEntry)
    {
        boolean found = false;

        if (!isEmpty())
        {
            int position = getPosition(anEntry);
            if (position >= 0)
            {
                removeGap(position);
                this.numberOfEntries--;
                found = true;
            } // end if
        } // end if

        return found;
    } // end remove

    public int getPosition(T anEntry)
    {
        int position = 1;

        while ((position <= this.numberOfEntries) && (anEntry.compareTo(getEntry(position)) > 0))
        {
            position++;
        } // end while

        if ((position > this.numberOfEntries) || !anEntry.equals(getEntry(position)))
        {
            position = -position;
        } // end if

        return position;
    } // end getPosition

    // list operations
    public T getEntry(int givenPosition)
    {
        T result = null; // result to return

        if (givenPosition >= 1 && givenPosition <= this.numberOfEntries)
        {
            assert !isEmpty();
            result = this.list[givenPosition - 1];
        } // end if

        return result;
    } // end getEntry

    public boolean contains(T anEntry)
    {
        boolean found = false;
        for (int index = 0; !found && (index < this.numberOfEntries); index++)
        {
            if (anEntry.equals(this.list[index]))
                found = true;
        } // end for

        return found;
    } // end contains

    public T remove(int givenPosition)
    {
        T result = null; // return value

        if ((givenPosition >= 1) && (givenPosition <= this.numberOfEntries)) // test catches empty list
        {
            assert !isEmpty();

            result = this.list[givenPosition - 1]; // get entry to be removed

            // move subsequent entries towards entry to be removed,
            // unless it is last in list
            if (givenPosition < this.numberOfEntries)
                removeGap(givenPosition);

            this.numberOfEntries--;
        } // end if

        return result; // return reference to removed entry,
        // or null if list is empty
    } // end remove

    public void clear()
    {
        for (int index = 0; index < this.numberOfEntries; index++)
            this.list[index] = null;

        this.numberOfEntries = 0; // no need to create a new array
    } // end clear

    public int getLength()
    {
        return this.numberOfEntries;
    } // end getLength

    public boolean isEmpty()
    {
        return this.numberOfEntries == 0;
    } // end isEmpty

    public T[] toArray()
    {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[this.numberOfEntries];
        for (int index = 0; index < this.numberOfEntries; index++)
        {
            result[index] = this.list[index];
        } // end for
        return result;
    } // end toArray

    // Doubles the size of the array list if it is full.
    private void ensureCapacity()
    {
        if (this.numberOfEntries == this.list.length)
            this.list = Arrays.copyOf(this.list, 2 * this.list.length);
    } // end ensureCapacity

    /**
     * Shifts entries that are beyond the entry to be removed
     * to the next lower position.
     * Precondition: list is not empty; 1 <= givenPosition < numberOfEntries;
     *                numberOfEntries is list's numberOfEntries before removal.
     */
    private void removeGap(int givenPosition)
    {
        assert (givenPosition >= 1) && (givenPosition < this.numberOfEntries);

        // move each entry to next lower position starting at entry after the
        // one removed and continuing until end of array
        int removedIndex = givenPosition - 1;
        int lastIndex = this.numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++)
            this.list[index] = this.list[index + 1];
    } // end removeGap

    /**
     * displays this.numberOfEntries elements in the list
     *
     */
    public void display()
    {
        System.out.print("\nThe data has " + this.numberOfEntries + " elements: ");
        for (int i = 0; i < this.numberOfEntries; i++)
        {
            System.out.print(this.list[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        SortedArrayListWithMode<Integer> data = new SortedArrayListWithMode<Integer>();
        for (int i = 0; i < 10; i++)
            data.add(i);

        data.display();
        System.out.println("The mode should be 0, got: " + data.getMode());

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < i; j++)
                data.add(i);

        data.display();
        System.out.println("The mode should be 9, got: " + data.getMode());

        for (int i = 0; i < 21; i++)
            for (int j = 8; j < i; j++)
                data.add(i);
        data.display();
        System.out.println("The mode should be 20, got: " + data.getMode());

        for (int i = 0; i < 14; i++)
            data.add(6);
        data.display();
        System.out.println("The mode should be 6, got: " + data.getMode());

        // test list of 1 element
        data = new SortedArrayListWithMode<Integer>(1);
        data.add(9);
        data.display();
        System.out.println("The mode should be 9, got: " + data.getMode());
    } // end main
} // end SortedArrayListWithMode