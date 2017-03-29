import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class that implements the ADT list by using a chain of nodes.
 * The list has an iterator. The class is similar to LList.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @modifiedBy Joshua Steward
 * @version 2/26/2015
 */
public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>
{
    private Node<T> firstNode;
    private int numberOfEntries;

    public LinkedListWithIterator()
    {
        clear();
    } // end default constructor

    public void clear()
    {
        this.firstNode = null;
        this.numberOfEntries = 0;
    } // end clear

    public void add(T newEntry)                   // OutOfMemoryError possible
    {
        Node<T> newNode = new Node<>(newEntry);

        if (isEmpty())
            this.firstNode = newNode;
        else                                      // Add to end of non-empty list
        {
            Node<T> lastNode = getNodeAt(this.numberOfEntries);
            lastNode.next = newNode;         // Make last node reference new node
        }

        this.numberOfEntries++;
    }  // end add

    public void add(int newPosition, T newEntry) // OutOfMemoryError possible
    {
        if ((newPosition >= 1) && (newPosition <= this.numberOfEntries + 1))
        {
            Node<T> newNode = new Node<>(newEntry);

            if (newPosition == 1)                  // Case 1
            {
                newNode.next = this.firstNode;
                this.firstNode = newNode;
            }
            else                                 // Case 2: list is not empty
            {                                      // and newPosition > 1
                Node<T> nodeBefore = getNodeAt(newPosition - 1);
                Node<T> nodeAfter = nodeBefore.next;
                newNode.next = nodeAfter;
                nodeBefore.next = newNode;
            }

            this.numberOfEntries++;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
    } // end add

    public T remove(int givenPosition)
    {
        T result = null;                          // Return value

        if ((givenPosition >= 1) && (givenPosition <= this.numberOfEntries))
        {
            assert !isEmpty();

            if (givenPosition == 1)                // Case 1: remove first entry
            {
                result = firstNode.data;       // Save entry to be removed
                this.firstNode = this.firstNode.next;
            }
            else                                   // Case 2: not first entry
            {
                Node<T> nodeBefore = getNodeAt(givenPosition - 1);
                Node<T> nodeToRemove = nodeBefore.next;
                Node nodeAfter = nodeToRemove.next;
                nodeBefore.next = nodeAfter;
                result = nodeToRemove.data;    // Save entry to be removed
            }

            this.numberOfEntries--;
            return result;                         // Return removed entry
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    } // end remove

    public T replace(int givenPosition, T newEntry)
    {
        if ((givenPosition >= 1) && (givenPosition <= this.numberOfEntries))
        {
            assert !isEmpty();

            Node<T> desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.data;
            desiredNode.data = newEntry;
            return originalEntry;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    } // end replace

    public T getEntry(int givenPosition)
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            assert !isEmpty();
            return (getNodeAt(givenPosition)).data;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    } // end getEntry

    public T[] toArray()
    {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[this.numberOfEntries];

        int index = 0;
        Node<T> currentNode = this.firstNode;
        while ((index < this.numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.data;
            currentNode = currentNode.next;
            index++;
        }

        return result;
    } // end toArray

    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node<T> currentNode = this.firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }

        return found;
    } // end contains

    public int getLength()
    {
        return this.numberOfEntries;
    } // end getLength

    public boolean isEmpty()
    {
        boolean result;

        if (this.numberOfEntries == 0)
        {
            assert this.firstNode == null;
            result = true;
        }
        else
        {
            assert this.firstNode != null;
            result = false;
        }

        return result;
    } // end isEmpty

    public Iterator<T> iterator()
    {
        return new IteratorForLinkedList();
    } // end iterator

    public Iterator<T> getIterator()
    {
        return iterator();
    } // end getIterator

    // Returns a reference to the node at a given position.
    // Precondition: List is not empty;
    //               1 <= givenPosition <= numberOfEntries.
    private Node<T> getNodeAt(int givenPosition)
    {
        assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= this.numberOfEntries);
        Node<T> currentNode = this.firstNode;

        // Traverse the chain to locate the desired node (skipped
        // if givenPosition is 1)
        for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.next;

        assert currentNode != null;

        return currentNode;
    } // end getNodeAt

//==================================

    public static void displayList(ListInterface<String> list)
    {
        int numberOfEntries = list.getLength();

        System.out.println("\nThe list contains " + numberOfEntries +
                " entries, as follows:");
        for (int position = 1; position <= numberOfEntries; position++)
            System.out.println(list.getEntry(position) + " is entry " + position);
        System.out.println();
    } // end displayList

    public void reverseLinkedListIteratively()
    {
        Node<T> newNext;
        Node<T> next1 = this.firstNode.next;
        Node<T> current = this.firstNode;
        while (next1 != null)
        {
            newNext = current;
            current = next1;
            next1 = next1.next;
            current.next = newNext;
        }

        this.firstNode.next = null;
        this.firstNode = current;
    }

    public void reverseLinkedListRecursively()
    {
        recursiveReverse(this.firstNode);
    }

    private void recursiveReverse(Node currentNode)
    {
        if (currentNode.next == null)
        {
            this.firstNode = currentNode;
        }
        else
        {
            recursiveReverse(currentNode.next);
            currentNode.next.next = currentNode;
            currentNode.next = null;
        }
    }

//==================================

    private class IteratorForLinkedList implements Iterator<T>
    {
        private Node<T> nextNode;  // Node containing next entry in iteration

        private IteratorForLinkedList()
        {
            this.nextNode = LinkedListWithIterator.this.firstNode;
        } // end default constructor

        public boolean hasNext()
        {
            return this.nextNode != null;
        } // end hasNext

        public T next()
        {
            if (hasNext())
            {
                Node<T> returnNode = this.nextNode;        // Get next node
                this.nextNode = this.nextNode.next; // Advance iterator

                return returnNode.data;       // Return next entry in iteration
            }
            else
                throw new NoSuchElementException("Illegal call to next(); " +
                        "iterator is after end of list.");
        } // end next

        public void remove()
        {
            throw new UnsupportedOperationException("remove() is not " +
                    "supported by this iterator");
        } // end remove
    } // end IteratorForLinkedList

    private class Node<S>
    {
        private S data; // Entry in list
        private Node<S> next; // Link to next node

        private Node(S dataPortion)
        {
            this(dataPortion, null);
        } // end constructor

        private Node(S dataPortion, Node nextNode)
        {
            this.data = dataPortion;
            this.next = nextNode;
        } // end constructor
    }

    public static void main(String[] args)
    {
        testReverseMethods();
        //testExamples();
        System.out.println("*** Done ***");
    }  // end main

    public static void testReverseMethods()
    {
        System.out.println("*** Create a list ***");
        LinkedListWithIterator<String> myList = new LinkedListWithIterator<>();
        myList.add("15");
        myList.add("25");
        myList.add("35");
        myList.add("45");
        myList.add("55");
        myList.add("65");
        myList.add("75");
        myList.add("85");
        myList.add("95");

        System.out.println("List should contain: 15 25 35 45 55 65 75 85 95");
        System.out.println("\nUsing ADT list operations, the list contains: ");
        displayList(myList);

        System.out.println("\nUsing Iterator methods, the list contains");
        Iterator<String> myIterator = myList.iterator();

        while (myIterator.hasNext())
            System.out.print(myIterator.next() + " ");
        System.out.println();
        System.out.println();

        System.out.println("\n*** Calling reverseLinkedListIteratively ***");
        myList.reverseLinkedListIteratively();

        System.out.println("\nList should contain: 95 85 75 65 55 45 35 25 15");
        System.out.println("\nUsing ADT list operations, the list contains ");
        displayList(myList);

        System.out.println("\nUsing Iterator methods, the list contains");
        myIterator = myList.iterator();

        while (myIterator.hasNext())
            System.out.print(myIterator.next() + " ");
        System.out.println();


        System.out.println("===========================================================");

        System.out.println("\n\n*** Calling reverseLinkedListRecursively ***");
        myList.reverseLinkedListRecursively();
        System.out.println("\nList should contain: 15 25 35 45 55 65 75 85 95");
        System.out.println("\nUsing ADT list operations, the list contains ");
        displayList(myList);

        System.out.println("\nUsing Iterator methods, the list contains");
        myIterator = myList.iterator();

        while (myIterator.hasNext())
            System.out.print(myIterator.next() + " ");
        System.out.println();
        System.out.println();

    } // end testIteratorOperations

    public static void testExamples()
    {
        System.out.println("\nExamples from the textbook");
        ListWithIteratorInterface<String> nameList = new LinkedListWithIterator<>();
        nameList.add("Jamie");
        nameList.add("Joey");
        nameList.add("Rachel");
        System.out.println("List is jamie, joey, rachel");

        Iterator<String> nameIterator = nameList.getIterator();

        System.out.println("Output should be: true Jamie Joey Rachel false");
        System.out.print(nameIterator.hasNext() + " ");
        System.out.print(nameIterator.next() + " ");
        System.out.print(nameIterator.next() + " ");
        System.out.print(nameIterator.next() + " ");
        System.out.println(nameIterator.hasNext());
//      nameIterator.next(); // Causes a NoSuchElementException.
// ============================================================================

        System.out.println("-------------------------------");
        nameList = new LinkedListWithIterator<>();

        nameList.add("Brad");
        nameList.add("Jane");
        nameList.add("Bob");
        nameList.add("Jane");
        nameList.add("Bette");
        nameList.add("Brad");
        nameList.add("Jane");
        nameList.add("Brenda");
        System.out.println("List contains Brad, Jane, Bob, Jane, Bette, Brad, Jane, Brenda\n");

        nameIterator = nameList.getIterator();
        while (nameIterator.hasNext())
        {
            String currentName = nameIterator.next();
            int nameCount = 0;
            Iterator<String> countingIterator = nameList.getIterator();
            while (countingIterator.hasNext())
            {
                String nextName = countingIterator.next();
                if (currentName.equals(nextName))
                    nameCount++;
            }
            System.out.println(currentName + " occurs " +
                    nameCount + " times.");
        }

        System.out.println("\nOutput should be:");
        System.out.println("Brad occurs 2 times.");
        System.out.println("Jane occurs 3 times.");
        System.out.println("Bob occurs 1 times.");
        System.out.println("Jane occurs 3 times.");
        System.out.println("Bette occurs 1 times.");
        System.out.println("Brad occurs 2 times.");
        System.out.println("Jane occurs 3 times.");
        System.out.println("Brenda occurs 1 times.");
        System.out.println("======================");
    } // end testExamples
} // end LinkedListWithIterator



