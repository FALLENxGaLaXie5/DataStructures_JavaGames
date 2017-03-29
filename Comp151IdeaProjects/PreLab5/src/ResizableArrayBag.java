import java.util.Arrays;/** * A class that implements a bag of objects by using an array. * The bag is never full. * * @author Joshua Steward * @version 02/12/2015 */public class ResizableArrayBag<T extends Comparable<? super T>> implements BagInterface<T>{    private T bag[]; // cannot be final due to doubling    private static final int DEFAULT_INITIAL_CAPACITY = 25; // initial capacity of bag    private int numberOfEntries;    /**     * Creates an empty bag whose initial capacity is 25.     */    public ResizableArrayBag()    {        this(DEFAULT_INITIAL_CAPACITY);    } // end default constructor    /**     * Creates an empty bag having a given initial capacity.     *     * @param capacity the integer capacity desired     */    @SuppressWarnings("unchecked")    public ResizableArrayBag(int capacity)    {        this.numberOfEntries = 0;        // the cast is safe because the new array contains null entries        T[] tempBag = (T[]) new Comparable<?>[capacity]; // unchecked cast        this.bag = tempBag;    } // end constructor    /**     * Creates a bag containing given entries.     *     * @param contents an array of objects     */    public ResizableArrayBag(T[] contents)    {        this.bag = Arrays.copyOf(contents, contents.length);        this.numberOfEntries = contents.length;    } // end constructor    /**     * Adds a new entry to this bag.     *     * @param newEntry the object to be added as a new entry     * @return true if the addition is successful, or false if not     */    public boolean add(T newEntry)    {        ensureCapacity();        this.bag[numberOfEntries] = newEntry;        this.numberOfEntries++;        return true;    } // end add    // Doubles the size of the array bag if it is full    private void ensureCapacity()    {        if (this.numberOfEntries == this.bag.length)            this.bag = Arrays.copyOf(this.bag, 2 * this.bag.length);    } // end ensureCapacity    /**     * @return true; the bag is never full because the array bag is     *         re-sized, as necessary     */    public boolean isFull()    {        return false;    } // end isFull    /**     * Retrieves all entries that are in this bag.     *     * @return a newly allocated array of all the entries in the bag     */    public T[] toArray()    {        // the cast is safe because the new array contains null entries        @SuppressWarnings("unchecked")        T[] result = (T[]) new Comparable<?>[this.numberOfEntries]; // unchecked cast        for (int index = 0; index < this.numberOfEntries; index++)        {            result[index] = this.bag[index];        } // end for        return result;    } // end toArray    /**     * Sees whether this bag is empty.     *     * @return true if this bag is empty, or false if not     */    public boolean isEmpty()    {        return this.numberOfEntries == 0;    } // end isEmpty    /**     * Gets the (current) capacity of this bag.     *     * @return the integer number of entries that the bag can hold     */    public int getCapacity()    {        return this.bag.length;    } // end getCapacity    /**     * Gets the number of entries currently in this bag.     *     * @return the integer number of entries currently in the bag     */    public int getCurrentSize()    {        return this.numberOfEntries;    } // end getCurrentSize    /**     * Counts the number of times a given entry appears in this bag.     *     * @param anEntry the entry to be counted     * @return the number of times anEntry appears in the bag     *///    public int getFrequencyOf(T anEntry)//    {//        int counter = 0;////        for (int index = 0; index < this.numberOfEntries; index++)//        {//            if (anEntry.equals(this.bag[index]))//            {//                counter++;//            } // end if//        } // end for////        return counter;//    } // end getFrequencyOf    public int getFrequencyOf(T anEntry)    {        return getFrequencyOf(anEntry, numberOfEntries);    }    // howMany is the number of bag entries left to examine    private int getFrequencyOf(T anEntry, int howMany)    {        if (howMany == 0)        {            return 0;        }        else        {            if (this.bag[howMany - 1].equals(anEntry))            {                return getFrequencyOf(anEntry, howMany - 1) + 1;            }            else            {                return getFrequencyOf(anEntry, howMany - 1);            }        }    }    /**     * Tests whether this bag contains a given entry.     *     * @param anEntry the entry to locate     * @return true if the bag contains anEntry, or false otherwise     */    public boolean contains(T anEntry)    {        return getIndexOf(anEntry) > -1;    } // end contains    // Locates a given object within the array bag.    // Returns the index of the object, if located,    // or -1 otherwise.    private int getIndexOf(T anEntry)    {        int where = -1;        boolean stillLooking = true;        for (int index = 0; stillLooking && (index < this.numberOfEntries); index++)        {            if (anEntry.equals(this.bag[index]))            {                stillLooking = false;                where = index;            } // end if        } // end for        return where;    } // end getIndexOf    /**     * Removes all entries from this bag.     */    public void clear()    {        while (!isEmpty())            remove();    } // end clear    /**     * Removes one unspecified entry from this bag.     *     * @return either the removed entry, if the removal     *         was successful, or null otherwise     */    public T remove()    {        T result = removeEntry(this.numberOfEntries - 1);        return result;    } // end remove    /**     * Removes one occurrence of a given entry from this bag.     *     * @param anEntry the entry to be removed     * @return true if the removal was successful, or null otherwise     */    public boolean remove(T anEntry)    {        int index = getIndexOf(anEntry);        T result = removeEntry(index);        return anEntry.equals(result);    } // end remove    // Removes and returns the array entry at a given index.    // If no such entry exists, returns null.    private T removeEntry(int givenIndex)    {        T result = null;        if (!isEmpty() && (givenIndex >= 0))        {            result = this.bag[givenIndex]; // entry to remove            this.numberOfEntries--;            this.bag[givenIndex] = this.bag[this.numberOfEntries]; // replace entry to remove with last entry            this.bag[this.numberOfEntries] = null; // remove reference to last entry        } // end if        return result;    } // end removeEntry    /**     * Displays all the elements in the bag     */    public void display()    {        System.out.print("There are " + this.numberOfEntries + " element(s): ");        for (int index = 0; index < this.numberOfEntries; index++)        {            System.out.print(this.bag[index] + " ");        } // end for        System.out.println();    } // end display    public static void main(String[] args)    {        ResizableArrayBag<String> bag1 = new ResizableArrayBag<>();        bag1.add("A");        bag1.add("B");        bag1.add("A");        bag1.add("C");        bag1.add("B");        bag1.add("A");        bag1.add("B");        bag1.add("A");        bag1.add("X");        bag1.add("Z");        System.out.println("\n***Testing getFrequencyOf method***");        System.out.println("Bag1 contains:");        bag1.display();        System.out.println("There are " +  bag1.getFrequencyOf("Z") + " of \"Z\"");        System.out.println("There are " +  bag1.getFrequencyOf("X") + " of \"X\"");        System.out.println("There are " +  bag1.getFrequencyOf("A") + " of \"A\"");        System.out.println("There are " +  bag1.getFrequencyOf("B") + " of \"B\"");        System.out.println("There are " +  bag1.getFrequencyOf("C") + " of \"C\"");        System.out.println("There are " +  bag1.getFrequencyOf("K") + " of \"K\"");    } // end main} // end ResizableArrayBag