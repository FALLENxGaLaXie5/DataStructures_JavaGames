package Lab03;

/**
 * A class of bags whose entries are stored in a chain of linked nodes.
 * The bag is never full.
 *
 * @author Joshua Steward
 * @version 01/30/2015
 */
public class LinkedBag<T extends Comparable<? super T>> implements BagInterface<T>
{
    private Node<T> firstNode;       // reference to first node
    private int numberOfEntries;

    public LinkedBag()
    {
        this.firstNode = null;
        this.numberOfEntries = 0;
    } // end default constructor

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry the object to be added as a new entry
     * @return true
     */
    public boolean add(T newEntry) // OutOfMemoryError possible
    {
        // add to beginning of chain:
        Node<T> newNode = new Node<>(newEntry);
        newNode.next = this.firstNode;  // make new node reference rest of chain
        // (firstNode is null if chain is empty)
        this.firstNode = newNode;       // new node is at beginning of chain
        this.numberOfEntries++;

        return true;
    } // end add

    /**
     * Sees whether this bag is full.
     *
     * @return false
     */
    public boolean isFull()
    {
        return false;
    } // end isFull

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return a newly allocated array of all the entries in the bag
     */
    public T[] toArray()
    {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[this.numberOfEntries]; // unchecked cast

        int index = 0;
        Node<T> currentNode = this.firstNode;
        while ((index < this.numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        } // end while

        return result;
    } // end toArray

    /**
     * Sees whether this bag is empty.
     *
     * @return true if the bag is empty, or false if not
     */
    public boolean isEmpty()
    {
        return this.numberOfEntries == 0;
    } // end isEmpty

    /**
     * Gets the number of entries currently in this bag.
     *
     * @return the integer number of entries currently in the bag
     */
    public int getCurrentSize()
    {
        return this.numberOfEntries;
    } // end getCurrentSize

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry the entry to be counted
     * @return the number of times anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;

        int counter = 0;
        Node<T> currentNode = this.firstNode;
        while ((counter < this.numberOfEntries) && (currentNode != null))
        {
            if (anEntry.equals(currentNode.data))
            {
                frequency++;
            } // end if

            counter++;
            currentNode = currentNode.next;
        } // end while

        return frequency;
    } // end getFrequencyOf

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry the entry to locate
     * @return true if the bag contains anEntry, or false otherwise
     */
    public boolean contains(T anEntry)
    {
        return getReferenceTo(anEntry) != null;
    } // end contains

    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located,
    // or null otherwise.
    private Node<T> getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node<T> currentNode = this.firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        } // end while

        return currentNode;
    } // end getReferenceTo

    /**
     * Removes all entries from this bag.
     */
    public void clear()
    {
        while (!isEmpty())
            remove();
    } // end clear

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return either the removed entry, if the removal
     * was successful, or null
     */
    public T remove()
    {
        T result = null;
        if (this.firstNode != null)
        {
            result = this.firstNode.data;
            this.firstNode = this.firstNode.next; // remove first node from chain
            this.numberOfEntries--;
        } // end if

        return result;
    } // end remove

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     *
     * @param anEntry the entry to be removed
     * @return true if the removal was successful, or false otherwise
     */
    public boolean remove(T anEntry)
    {
        boolean result = false;
        Node<T> nodeN = getReferenceTo(anEntry);

        if (nodeN != null)
        {
            nodeN.data = this.firstNode.data; // replace located entry with entry in first node

            remove();                    // remove first node
            result = true;
        } // end if

        return result;
    } // end remove

    // ****** IMPLEMENT THE FOLLOWING METHODS ********

    /**
     * Displays all the elements in the bag
     */

    public void display()
    {
		/*
		*set currentNodeDate equal to the data entry of the firstNode instance variable
	 *Using a for loop, iterate from 0 to the numberOfEntries, or until encountering a null entry
	 *	inside for loop: print currentNode data
	 *					 set the currentNodeData to the next node
	 *- End Display Method
	 */
        System.out.println("display method - IMPLEMENT ME");

    } // end display

    /**
     * Checks if the given bag called other is the same as the bag
     *
     * @param otherBag the other bag to be compared with
     * @return true both bags are the same
     */
	 
	 /*
	 *First, initialize otherBag as other.
	 *set flag variable to true
	 * initialize current object
	 * check to see if number of entries is the same
	 * using a for loop, iterate until it hits numberofEntries, or flag is set to false
	 * for eaach iteration, check to see if data is the same, and then set currentObject to the linked next variable.
	 *
	 */
    public boolean equals(BagInterface<T> otherBag)
    {
        LinkedBag<T> other = (LinkedBag<T>) otherBag;
        boolean same = false;
        System.out.println("equals method - IMPLEMENT ME");

        return same;
    }

    /**
     * Removes the largest element from the bag
     *
     * @return - null if the element was not found or the element
     * <p/>
     * NOTE: the method must traverse the data with a while loop; calls remove()
     */

    public T removeMax()
    {
        /**
         * Largest = firstNode
         *
         */
        /**
         * initialize currentEntrty as the firstNode
         * First, set the largest element to the first node.
         * Next, iterate through to the numberofEntries or until you hit a null entry
         *      for each entry, compare it to the currentLargest entry.
         *      if the currententry is larger than the currentLargest entry, set the currentLargest to the currentEntry
         *      otherwise, set the currententry to the next linked node.
         */
        T largest = null; // return value

        System.out.println("removeMax method - IMPLEMENT ME");

        return largest;
    } // end remove element

    /**
     * Removes every occurrence of a given entry from this bag.
     * For efficiency it traverses the data and removes entries as it traverses the list
     * without calling any other method
     *
     * @param anEntry the entry to be removed
     */
    public void removeEvery(T anEntry)
    {
        /**
         * sets currentEntry to firstNode
         * looping through the entire linked list
         *      compares currentEntry to anEntry.
         *      if they are equal, remove currentEntry
         *      else, set currentEntry to the next linked node.
         */
        System.out.println("removeEvery method - IMPLEMENT ME");

        // use one loop only, change appropriate pointers, no calls to other methods

    } // end removeEvery

    /**
     * Gets the smallest value in this bag.
     *
     * @returns a reference to the smallest object, or null if the bag is empty
     */
    public T getMin()
    {
        /**
         * sets currentEntry to firstNode
         * sets smallestObject to currentEntry
         * looping through the entire linked list
         *      compares currentEntry to smallestObject
         *      if currentEntry compared to smallestObject is smaller,
         *          set smallestObject to currentEntry
         * return smallestObject
         */
        T smallestValue = null;

        System.out.println("getMin method - IMPLEMENT ME");

        return smallestValue;
    } // end getMin

    /**
     * Creates a new bag that combines the contents of this bag and a
     * second given bag without affecting the original two bags.
     *
     * @param otherBag the given bag
     * @return a bag that is the union of the two bags
     */
    public BagInterface<T> union(BagInterface<T> otherBag)
    {
        /**
         * First, initialize other as otherBag paramter
         * Next, initialize unionBag as the original bag.
         * Next, set currentObject to the other bags firstNode
         * using a for loop, iterate through the other bag until you hit number of entries
         *      add each entry to the unionBag
         *      set the currentObject to the other bag's next reference
         * return unionBag
         */
        LinkedBag<T> other = (LinkedBag<T>) otherBag;
        LinkedBag<T> unionBag = new LinkedBag<>();

        System.out.println("union method - IMPLEMENT ME");

        return unionBag;
    } // end union

    /**
     * Creates a new bag that contains those objects that occur in both this
     * bag and a second given bag without affecting the original two bags.
     *
     * @param otherBag the given bag
     * @return a bag that is the intersection of the two bags
     */
    public BagInterface<T> intersection(BagInterface<T> otherBag)
    {
        /**
         * First, initialize other as otherBag paramter, intersectionBag as a new LinkedBag, and copyOfotherBag
         *      as a copy of other.
         * set currentObject to firstNode
         * using a forloop, iterate until you reach numberOfEntries
         *      if remove currentObject comes up as true
         *          add it to the intersectionBag
         *      set currentObject to the reference to the next linked node
         * return the intersectionBag
         */
        LinkedBag<T> other = (LinkedBag<T>) otherBag;
        LinkedBag<T> intersectionBag = new LinkedBag<>();
        LinkedBag<T> copyOfOtherBag = new LinkedBag<>();

        System.out.println("intersection method - IMPLEMENT ME");

        // do not call contains, call remove(anEntry) instead

        return intersectionBag;
    } // end intersection

    /**
     * Creates a new bag of objects that would be left in this bag
     * after removing those that also occur in a second given bag
     * without affecting the original two bags.
     *
     * @param otherBag the given bag
     * @return a bag that is the difference of the two bags
     */
    public BagInterface<T> difference(BagInterface<T> otherBag)
    {
        /**
         * difference bag is all the items in the first bag
         * iterate through the second bag, check against the first bag
         *      when removed, swap it out of the difference bag, find the entry and switch it out
         */
        /**
         * Initialize other as otherBag and differenceBag as this bag
         * set the currentObject to the firstNode
         * looping through a for loop
         *      if remove the currentObject returns true
         *          remove entry
         * set currentEntry to the next linked variable
         * return the differenceBag
         */
        LinkedBag<T> other = (LinkedBag<T>) otherBag;
        LinkedBag<T> differenceBag = new LinkedBag<>();

        System.out.println("difference method - IMPLEMENT ME");

        // do not call contains, call remove(anEntry) instead

        return differenceBag;
    } // end difference

    public void moveFirstToEnd()
    {
        /**
         * Set currentNode to firstNode
         * using for loop, iterate straight from the firstNode to the numberOfEntries in one iteration
         *      set currentNode to lastNode
         * set lastNode to firstNode
         */
        System.out.println("moveFirstToEnd method - IMPLEMENT ME");

        // do not create a new node, just change appropriate pointers

    } // end moveToEnd

    /**
     * Replaces an entry in this bag with a given object.
     *
     * @param replacement the given object
     * @return the original entry in the bag that was replaced
     */
    public T replace(T replacement)
    {
        /**
         * set replacementNode equal to firstNode
         * set firstNode equal to replacement
         */
        T replacedEntry = null;

        System.out.println("replace method - IMPLEMENT ME");

        // do not create a new node, just change the data

        return replacedEntry;
    } // end replace

    /**
     * Checks if all the elements of the given bag are also included in the other bag
     *
     * @param otherBag bag to check
     * @return returns true if all the elements of the given bag are also included in the other bag
     */
    public boolean isSubset(BagInterface<T> otherBag)
    {
        /**
         * call difference method; if the difference array length is equal to 0, it is a subset
         * Otherwise, iterate through and check every entry.
         */
        System.out.println("isSubset method - IMPLEMENT ME");

        // utilize difference method

        return false;
    }

    private class Node<S>
    {
        private S data; // entry in bag
        private Node<S> next; // link to next node

        private Node(S dataPortion)
        {
            this(dataPortion, null);
        } // end constructor

        private Node(S dataPortion, Node nextNode)
        {
            this.data = dataPortion;
            this.next = nextNode;
        } // end constructor
    } // end Node

    public static void main(String[] args)
    {
        System.out.println("RUNNING TEST CASES");

        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> testBag = new LinkedBag<>();

        bag1.add("A");
        bag1.add("B");
        bag1.add("A");
        bag1.add("C");
        bag1.add("B");

        // testing display
        System.out.println("\n***Testing display method***");
        System.out.println("bag1 is ");
        bag1.display();

        System.out.println("bag2 is ");
        bag2.display();

        System.out.println("After removing the first element " + bag1.remove() + " from bag1, it contains");
        bag1.display();

        // testing equals
        System.out.println("\n***Testing equals method***");
        System.out.println("Are bag1 and bag2 equal? --> " + (bag1.equals(bag2) ? "YES" : "NO"));
        System.out.println("Are bag2 and bag1 equal? --> " + (bag2.equals(bag1) ? "YES" : "NO"));
        bag2.add("A");
        bag2.add("C");
        bag2.add("A");
        bag2.add("B");
        bag2.add("X");
        System.out.println("bag2:");
        bag2.display();
        System.out.println("Are bag1 and bag2 equal? --> " + (bag1.equals(bag2) ? "YES" : "NO"));
        System.out.println("Removed " + bag2.remove() + " from bag2.");
        bag2.display();
        System.out.println("Are bag1 and bag2 equal now? --> " + (bag1.equals(bag2) ? "YES" : "NO"));
        LinkedBag<String> bagCopyOfBag1 = new LinkedBag<String>();
        bagCopyOfBag1.add("A");
        bagCopyOfBag1.add("B");
        bagCopyOfBag1.add("A");
        bagCopyOfBag1.add("C");
        System.out.println("Created bagCopyOfBag1:");
        bagCopyOfBag1.display();
        System.out.println("Are bag1 and bagCopyOfBag1 equal? --> " + (bag1.equals(bagCopyOfBag1) ? "YES" : "NO"));

        bag1.clear();
        bag1.add("A");
        bag1.add("A");
        bag1.add("B");
        bag1.add("X");
        bag1.add("A");
        bag1.add("C");
        bag1.add("A");
        bag2.clear();
        bag2.add("A");
        bag2.add("B");
        bag2.add("B");
        bag2.add("A");
        bag2.add("C");
        bag2.add("C");
        bag2.add("D");

        // testing smallest
        System.out.println("\n***Testing smallest method***");
        System.out.print("bag1: ");
        bag1.display();
        System.out.print("bag2: ");
        bag2.display();
        System.out.println("The smallest item in bag1 is: " + bag1.getMin());
        System.out.println("The smallest item in bag2 is: " + bag2.getMin());

        System.out.println("\n***Testing union, removeMax, intersection, difference and subset methods***");
        System.out.print("bag1: ");
        bag1.display();
        System.out.print("bag2: ");
        bag2.display();

        // testing union
        System.out.println("\n***Testing union method***");
        BagInterface<String> everything = bag1.union(bag2);
        System.out.println("The union of bag1 and bag2 is ");
        everything.display();

        // testing removeMax
        System.out.println("\n***Testing removeMax method***");
        String largest = everything.removeMax();
        System.out.println("Removed the largest element \"" + largest + "\" from the union bag; the current content is:");
        everything.display();
        everything.clear();
        largest = everything.removeMax();
        if (largest == null)
            System.out.println("The bag is empty and removeMax returned null - CORRECT");
        else
            System.out.println("The bag is empty bur removeMax returned did not return null - INCORRECT");

        // testing intersection
        System.out.println("\n***Testing intersection method***");
        BagInterface<String> commonItems = bag1.intersection(bag2);
        System.out.println("The intersection of bag1 and bag2 is ");
        commonItems.display();

        // testing difference
        System.out.println("\n***Testing difference method***");
        BagInterface<String> leftOver = bag1.difference(bag2);
        System.out.println("The difference of bag1 and bag2 is ");
        leftOver.display();

        leftOver = bag2.difference(bag1);
        System.out.println("The difference of bag2 and bag1 is ");
        leftOver.display();

        // testing subset
        System.out.println("\n***Testing subset method***");
        System.out.println("Is bag1 a subset of bag1 ? --> " + (bag1.isSubset(bag1) ? "YES" : "NO"));
        System.out.println("Is bag1 a subset of bag2 ? --> " + (bag1.isSubset(bag2) ? "YES" : "NO"));
        LinkedBag<String> emptyBag = new LinkedBag<>();
        System.out.println("Is an empty bag a subset of bag2 ? --> " + (emptyBag.isSubset(bag2) ? "YES" : "NO"));
        System.out.println("Is bag2 a subset of an empty bag ? --> " + (bag2.isSubset(emptyBag) ? "YES" : "NO"));
        LinkedBag<String> bag3 = new LinkedBag<>();
        LinkedBag<String> bag4 = new LinkedBag<>();
        bag3.add("A");
        bag3.add("B");
        bag3.add("C");
        System.out.println("Created bag3:");
        bag3.display();

        bag4.add("B");
        bag4.add("C");
        bag4.add("A");
        System.out.println("Created bag4:");
        bag4.display();

        System.out.println("Is bag3 a subset of bag4 ? --> " + (bag3.isSubset(bag4) ? "YES" : "NO"));
        bag4.add("Z");
        System.out.println("Is bag3 a subset of bag4 after adding \"Z\" to it ? --> " + (bag3.isSubset(bag4) ? "YES" : "NO"));
        System.out.println("Is bag4 a subset of bag3 ? --> " + (bag4.isSubset(bag3) ? "YES" : "NO"));
        System.out.println("Adding  \"Z\" to bag3 twice");
        bag3.add("Z");
        bag3.add("Z");
        System.out.println("Bag3 is:");
        bag3.display();
        System.out.println("Bag4 is:");
        bag4.display();
        System.out.println("Is bag3 a subset of bag4 ? --> " + (bag3.isSubset(bag4) ? "YES" : "NO"));


        bag1.clear();
        bag1.add("A");
        bag1.add("A");
        bag1.add("B");
        bag1.add("X");
        bag1.add("A");
        bag1.add("C");
        bag1.add("A");
        // testing replace
        System.out.println("\n***Testing replace method***");
        System.out.println("Bag1 contains:");
        bag1.display();
        System.out.println("Replacing an element with \"X\"");
        bag1.replace("X");
        System.out.println("Now bag1 contains:");
        bag1.display();

        // testing removeEvery
        System.out.println("\n***Testing removeEvery method***");
        System.out.println("Bag1 contains:");
        bag1.display();
        System.out.println("Removing all \"Z\"");
        bag1.removeEvery("Z");
        System.out.println("After removing all \"Z\" bag1 contains:");
        bag1.display();
        System.out.println("Removing all \"X\"");
        bag1.removeEvery("X");
        System.out.println("After removing all \"X\" bag1 contains:");
        bag1.display();
        System.out.println("After adding two \"A\" bag1 contains:");
        bag1.add("A");
        bag1.add("A");
        bag1.display();
        System.out.println("Removing all \"A\"");
        bag1.removeEvery("A");
        System.out.println("After removing all \"A\" bag1 contains:");
        bag1.display();
        System.out.println("Removing all \"B\"");
        bag1.removeEvery("B");
        System.out.println("After removing all \"B\" bag1 contains:");
        bag1.display();

        System.out.println("\n*** TESTING moveFirstToEnd ***");
        System.out.println("Cycling list 1 once");
        testBag.clear();
        testBag.add("C");
        testBag.add("B");
        testBag.add("A");
        System.out.println("List before:");
        testBag.display();
        testBag.moveFirstToEnd();
        System.out.println("List after:");
        testBag.display();
        System.out.println();

        System.out.println("Cycling list 3 three times");
        testBag.clear();
        testBag.add("B");
        testBag.add("C");
        testBag.add("A");
        System.out.println("List before:");
        testBag.display();
        testBag.moveFirstToEnd();
        testBag.moveFirstToEnd();
        testBag.moveFirstToEnd();
        System.out.println("List after:");
        testBag.display();
        System.out.println();

        System.out.println("Cycling list of length 0");
        testBag.clear();
        System.out.println("List before:");
        testBag.display();
        testBag.moveFirstToEnd();
        System.out.println("List after:");
        testBag.display();
        System.out.println();

        System.out.println("Cycling list of length 1");
        testBag.clear();
        testBag.add("B");
        System.out.println("List before:");
        testBag.display();
        testBag.moveFirstToEnd();
        System.out.println("List after:");
        testBag.display();
        System.out.println();

        System.out.println("Cycling list of length 2");
        testBag.clear();
        testBag.add("A");
        testBag.add("B");
        System.out.println("List before:");
        testBag.display();
        testBag.moveFirstToEnd();
        System.out.println("List after:");
        testBag.display();
        System.out.println();
    } // end main
} // end LinkedBag
