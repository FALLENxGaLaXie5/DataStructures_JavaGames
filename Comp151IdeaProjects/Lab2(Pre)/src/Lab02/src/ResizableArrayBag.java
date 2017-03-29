package Lab02;import java.util.Arrays;/** * A class that implements a bag of objects by using an array. * The bag is never full. * * @author YOUR NAME * @version 01/24/2015 */public class ResizableArrayBag<T extends Comparable<? super T>> implements BagInterface<T>{    private T bag[]; // cannot be final due to doubling    private static final int DEFAULT_INITIAL_CAPACITY = 25; // initial capacity of bag    private int numberOfEntries;    /**     * Creates an empty bag whose initial capacity is 25.     */    public ResizableArrayBag()    {        this(DEFAULT_INITIAL_CAPACITY);    } // end default constructor    /**     * Creates an empty bag having a given initial capacity.     *     * @param capacity the integer capacity desired     */    @SuppressWarnings("unchecked")    public ResizableArrayBag(int capacity)    {        this.numberOfEntries = 0;        // the cast is safe because the new array contains null entries        T[] tempBag = (T[]) new Comparable<?>[capacity]; // unchecked cast        this.bag = tempBag;    } // end constructor    /**     * Creates a bag containing given entries.     *     * @param contents an array of objects     */    public ResizableArrayBag(T[] contents)    {        this.bag = Arrays.copyOf(contents, contents.length);        this.numberOfEntries = contents.length;    } // end constructor    /**     * Adds a new entry to this bag.     *     * @param newEntry the object to be added as a new entry     * @return true if the addition is successful, or false if not     */    public boolean add(T newEntry)    {        ensureCapacity();        this.bag[numberOfEntries] = newEntry;        this.numberOfEntries++;        return true;    } // end add    // Doubles the size of the array bag if it is full    private void ensureCapacity()    {        if (this.numberOfEntries == this.bag.length)            this.bag = Arrays.copyOf(this.bag, 2 * this.bag.length);    } // end ensureCapacity    /**     * @return true; the bag is never full because the array bag is     *         re-sized, as necessary     */    public boolean isFull()    {        return false;    } // end isFull    /**     * Retrieves all entries that are in this bag.     *     * @return a newly allocated array of all the entries in the bag     */    public T[] toArray()    {        // the cast is safe because the new array contains null entries        @SuppressWarnings("unchecked")        T[] result = (T[]) new Comparable<?>[this.numberOfEntries]; // unchecked cast        for (int index = 0; index < this.numberOfEntries; index++)        {            result[index] = this.bag[index];        } // end for        return result;    } // end toArray    /**     * Sees whether this bag is empty.     *     * @return true if this bag is empty, or false if not     */    public boolean isEmpty()    {        return this.numberOfEntries == 0;    } // end isEmpty    /**     * Gets the (current) capacity of this bag.     *     * @return the integer number of entries that the bag can hold     */    public int getCapacity()    {        return this.bag.length;    } // end getCapacity    /**     * Gets the number of entries currently in this bag.     *     * @return the integer number of entries currently in the bag     */    public int getCurrentSize()    {        return this.numberOfEntries;    } // end getCurrentSize    /**     * Counts the number of times a given entry appears in this bag.     *     * @param anEntry the entry to be counted     * @return the number of times anEntry appears in the bag     */    public int getFrequencyOf(T anEntry)    {        int counter = 0;        for (int index = 0; index < this.numberOfEntries; index++)        {            if (anEntry.equals(this.bag[index]))            {                counter++;            } // end if        } // end for        return counter;    } // end getFrequencyOf    /**     * Tests whether this bag contains a given entry.     *     * @param anEntry the entry to locate     * @return true if the bag contains anEntry, or false otherwise     */    public boolean contains(T anEntry)    {        return getIndexOf(anEntry) > -1;    } // end contains    // Locates a given object within the array bag.    // Returns the index of the object, if located,    // or -1 otherwise.    private int getIndexOf(T anEntry)    {        int where = -1;        boolean stillLooking = true;        for (int index = 0; stillLooking && (index < this.numberOfEntries); index++)        {            if (anEntry.equals(this.bag[index]))            {                stillLooking = false;                where = index;            } // end if        } // end for        return where;    } // end getIndexOf    /**     * Removes all entries from this bag.     */    public void clear()    {        while (!isEmpty())            remove();    } // end clear    /**     * Removes one unspecified entry from this bag.     *     * @return either the removed entry, if the removal     *         was successful, or null otherwise     */    public T remove()    {        T result = removeEntry(this.numberOfEntries - 1);        return result;    } // end remove    /**     * Removes one occurrence of a given entry from this bag.     *     * @param anEntry the entry to be removed     * @return true if the removal was successful, or null otherwise     */    public boolean remove(T anEntry)    {        int index = getIndexOf(anEntry);        T result = removeEntry(index);        return anEntry.equals(result);    } // end remove    // Removes and returns the array entry at a given index.    // If no such entry exists, returns null.    private T removeEntry(int givenIndex)    {        T result = null;        if (!isEmpty() && (givenIndex >= 0))        {            result = this.bag[givenIndex]; // entry to remove            this.numberOfEntries--;            this.bag[givenIndex] = this.bag[this.numberOfEntries]; // replace entry to remove with last entry            this.bag[this.numberOfEntries] = null; // remove reference to last entry        } // end if        return result;    } // end removeEntry    //    // +++++++++++++++++++  NEW METHODS  +++++++++++++++++++++++++++    //    /**     * Displays all the elements in the bag     */    public void display()    {        System.out.println("display method - IMPLEMENT ME");    } // end display    /**     * Checks if the given bag called other is the same as the bag     *     * @param otherBag the other bag to be compared with     * @return true both bags are the same     */    public boolean equals(BagInterface<T> otherBag)    {        ResizableArrayBag<T> other = (ResizableArrayBag<T>) otherBag;        System.out.println("equals method - IMPLEMENT ME");        return false;    }    /**     * Removes the largest entry from the this.bag     *     * @return - null if the element was not found or the largest element. Uses removeEntry at index method     */    public T removeMax()    {        T largest = null;        System.out.println("removeMax method - IMPLEMENT ME");        return largest;    } // end removeMax    /**     * Removes every occurrence of a given entry from this bag. Uses removeEntry at index method     *     * @param anEntry the entry to be removed     */    public void removeEvery(T anEntry)    {        System.out.println("removeEvery method - IMPLEMENT ME");        // must utilize only one loop that starts with the last element    } // end removeEvery    /**     * Replaces an entry in this bag with a given object.     *     * @param replacement the given object     * @return the original entry in the bag that was replaced     */    public T replace(T replacement)    {        T replacedEntry = null;        System.out.println("replace method - IMPLEMENT ME");        // replace data at selected index        return replacedEntry;    } // end replace    /**     * Creates a new bag that combines the contents of this bag and a     * second given bag without affecting the original two bags.     *     * @param otherBag the given bag     * @return a bag that is the union of the two bags     */    public BagInterface<T> union(BagInterface<T> otherBag)    {        ResizableArrayBag<T> other = (ResizableArrayBag<T>) otherBag;        ResizableArrayBag<T> unionBag = new ResizableArrayBag<T>();        System.out.println("union method - IMPLEMENT ME");        return unionBag;    } // end union    /**     * Creates a new bag that contains those objects that occur in both this     * bag and a second given bag without affecting the original two bags.     * utilizes getIndexOf(anEntry) and remove(givenIndex) methods     *     * @param otherBag the given bag     * @return a bag that is the intersection of the two bags     */    public BagInterface<T> intersection(BagInterface<T> otherBag)    {        ResizableArrayBag<T> other = (ResizableArrayBag<T>) otherBag;        ResizableArrayBag<T> intersectionBag = new ResizableArrayBag<T>();        ResizableArrayBag<T> copyOfOtherBag = new ResizableArrayBag<T>();        System.out.println("intersection method - IMPLEMENT ME");        // do NOT call contains, getIndexOf(anEntry) and remove(givenIndex) methods instead        return intersectionBag;    } // end intersection    /**     * Creates a new bag of objects that would be left in this bag     * after removing those that also occur in a second given bag     * without affecting the original two bags.     *     * @param otherBag the given bag     * @return a bag that is the difference of the two bags     */    public BagInterface<T> difference(BagInterface<T> otherBag)    {        ResizableArrayBag<T> other = (ResizableArrayBag<T>) otherBag;        ResizableArrayBag<T> differenceBag = new ResizableArrayBag<T>();        System.out.println("difference method - IMPLEMENT ME");        // do NOT call contains, utilize getIndexOf(anEntry) and remove(givenIndex) methods instead        return differenceBag;    } // end difference    /**     * Creates a new bag of objects that are in this bag and are less than a given object.     *     * @param anEntry a given object     * @return a new bag of objects that are in this bag and are less than anObject     */    public BagInterface<T> getAllLessThan(T anEntry)    {        BagInterface<T> result = new ResizableArrayBag<T>();        System.out.println("getAllLessThan method - IMPLEMENT ME");        return result;    } // end getAllLessThan    /**     * Checks if all the elements of the given bag are also included in the other bag     *     * @param other bag to check     * @return returns true if all the elements of the given bag are also included in the other bag     */    public boolean isSubset(BagInterface<T> other)    {        System.out.println("isSubset method - IMPLEMENT ME");        // utilize difference method        return false;    }    public static void main(String[] args)    {        System.out.println("RUNNING TEST CASES");        ResizableArrayBag<String> bag1 = new ResizableArrayBag<String>(3);        ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>();        bag1.add("C");        bag1.add("A");        bag1.add("A");        bag1.add("A");        bag1.add("X");        // testing display        System.out.println("\n***Testing display method***");        System.out.println("bag1:");        bag1.display();        System.out.println("bag2:");        bag2.display();        System.out.println("After removing the last element " + bag1.remove() + " from bag1, it contains");        bag1.display();        // testing equals        System.out.println("\n***Testing equals method***");        System.out.println("Are bag1 and bag2 equal? --> " + (bag1.equals(bag2) ? "YES" : "NO"));        System.out.println("Are bag2 and bag1 equal? --> " + (bag2.equals(bag1) ? "YES" : "NO"));        bag2.add("A");        bag2.add("A");        bag2.add("A");        bag2.add("C");        bag2.add("X");        System.out.println("bag2:");        bag2.display();        System.out.println("Are bag1 and bag2 equal? --> " + (bag1.equals(bag2) ? "YES" : "NO"));        System.out.println("Removed " + bag2.remove() + " from bag2.");        bag2.display();        System.out.println("Are bag1 and bag2 equal now? --> " + (bag1.equals(bag2) ? "YES" : "NO"));        ResizableArrayBag<String> bagCopyOfBag1 = new ResizableArrayBag<String>(bag1.toArray());        System.out.println("Created bagCopyOfBag1:");        bagCopyOfBag1.display();        System.out.println("Are bag1 and bagCopyOfBag1 equal? --> " + (bag1.equals(bagCopyOfBag1) ? "YES" : "NO"));        bag1.clear();        bag1.add("C");        bag1.add("A");        bag1.add("A");        bag1.add("X");        bag1.add("A");        bag2.clear();        bag2.add("A");        bag2.add("B");        bag2.add("B");        bag2.add("A");        bag2.add("C");        bag2.add("C");        bag2.add("D");        System.out.println("\n***Testing union, intersection, difference, removeMax, getAllLessThan and isSubset methods***");        System.out.println("bag1:");        bag1.display();        System.out.println("bag2:");        bag2.display();        // testing union        System.out.println("\n***Testing union method***");        BagInterface<String> everything = bag1.union(bag2);        System.out.println("The union of bag1 and bag2 is ");        everything.display();        // testing removeMax        System.out.println("\n***Testing removeMax method***");        String largest =  everything.removeMax();        System.out.println("Removed the largest element \"" + largest + "\" from the union bag; the current content is:");        everything.display();        everything.clear();        largest = everything.removeMax();        if (largest == null)            System.out.println("The bag is empty and removeMax returned null - CORRECT");        else            System.out.println("The bag is empty bur removeMax returned did not return null - INCORRECT");        // testing intersection        System.out.println("\n***Testing intersection method***");        BagInterface<String> commonItems = bag1.intersection(bag2);        System.out.println("The intersection of bag1 and bag2 is ");        commonItems.display();        // testing difference        System.out.println("\n***Testing difference method***");        BagInterface<String> leftOver = bag1.difference(bag2);        System.out.println("The difference of bag1 and bag2 is ");        leftOver.display();        leftOver = bag2.difference(bag1);        System.out.println("The difference of bag2 and bag1 is ");        leftOver.display();        // testing getAllLessThan        System.out.println("\n***Testing getAllLessThan method***");        BagInterface<String> smaller = bag1.getAllLessThan("Z");        System.out.println("The following entries in bag1 are smaller than \"Z\" ");        smaller.display();        smaller = bag2.getAllLessThan("C");        System.out.println("The following entries in bag2 are smaller than \"C\" ");        smaller.display();        // testing subset        System.out.println("\n***Testing isSubset method***");        System.out.println("Is bag1 a subset of bag1 ? --> " + (bag1.isSubset(bag1) ? "YES" : "NO"));        System.out.println("Is bag1 a subset of bag2 ? --> " + (bag1.isSubset(bag2) ? "YES" : "NO"));        ResizableArrayBag<String> emptyBag = new ResizableArrayBag<String>();        System.out.println("Is an empty bag a subset of bag2 ? --> " + (emptyBag.isSubset(bag2) ? "YES" : "NO"));        System.out.println("Is bag2 a subset of an empty bag ? --> " + (bag2.isSubset(emptyBag) ? "YES" : "NO"));        ResizableArrayBag<String> bag3 = new ResizableArrayBag<String>();        ResizableArrayBag<String> bag4 = new ResizableArrayBag<String>();        bag3.add("A");        bag3.add("B");        bag3.add("C");        System.out.println("Created bag3:");        bag3.display();        bag4.add("B");        bag4.add("C");        bag4.add("A");        System.out.println("Created bag4:");        bag4.display();        System.out.println("Is bag3 a subset of bag4 ? --> " + (bag3.isSubset(bag4) ? "YES" : "NO"));        bag4.add("Z");        System.out.println("Is bag3 a subset of bag4 after adding \"Z\" to it ? --> " + (bag3.isSubset(bag4) ? "YES" : "NO"));        System.out.println("Is bag4 a subset of bag3 ? --> " + (bag4.isSubset(bag3) ? "YES" : "NO"));        System.out.println("Adding  \"Z\" to bag 3 twice");        bag3.add("Z");        bag3.add("Z");        System.out.println("bag3:");        bag3.display();        System.out.println("bag4:");        bag4.display();        System.out.println("Is bag3 a subset of bag4 ? --> " + (bag3.isSubset(bag4) ? "YES" : "NO"));        bag1.clear();        bag1.add("A");        bag1.add("A");        bag1.add("B");        bag1.add("X");        bag1.add("A");        bag1.add("C");        bag1.add("A");        // testing replace        System.out.println("\n***Testing replace method***");        System.out.println("bag1:");        bag1.display();        System.out.println("Replacing an element with \"X\"");        bag1.replace("X");        System.out.println("Now bag1 contains:");        bag1.display();        // testing removeEvery        System.out.println("\n***Testing removeEvery method***");        System.out.println("bag1:");        bag1.display();        System.out.println("Removing all \"Z\"");        bag1.removeEvery("Z");        System.out.println("After removing all \"Z\" bag1 contains:");        bag1.display();        System.out.println("Removing all \"A\"");        bag1.removeEvery("A");        System.out.println("After removing all \"A\" bag1 contains:");        bag1.display();        System.out.println("Removing all \"X\"");        bag1.removeEvery("X");        System.out.println("After removing all \"X\" bag1 contains:");        bag1.display();    } // end main} // end ResizableArrayBag