/** * A class that implements the ADT sorted list by using a chain of linked nodes. * Duplicate entries are allowed. * * @author Frank M. Carrano * @version 03/22/2012 */public class SortedLinkedList<T extends Comparable<? super T>>        implements SortedListInterface<T>{    private Node firstNode; // reference to first node of chain    private int numberOfEntries;    public SortedLinkedList()    {        this.firstNode = null;        this.numberOfEntries = 0;    } // end default constructor    public void add(T newEntry)    {        Node newNode = new Node(newEntry);        Node nodeBefore = getNodeBefore(newEntry);        if (isEmpty() || (nodeBefore == null)) // add at beginning        {            newNode.next = this.firstNode;            this.firstNode = newNode;        } else                                   // add after nodeBefore        {            Node nodeAfter = nodeBefore.next;            newNode.next = nodeAfter;            nodeBefore.next = newNode;        } // end if        this.numberOfEntries++;    } // end add    /**     * Finds the node that is before the node that     * should or does contain a given entry.     *     * @param anEntry the object to be located     * @return either a reference to the node that is before the node     *         that contains or should contain anEntry, or null if     *         no prior node exists (that is, if anEntry belongs at     *         the beginning of the list)     */    private Node getNodeBefore(T anEntry)    {        Node currentNode = this.firstNode;        Node nodeBefore = null;        while ((currentNode != null) &&                (anEntry.compareTo(currentNode.data) > 0))        {            nodeBefore = currentNode;            currentNode = currentNode.next;        } // end while        return nodeBefore;    } // end getNodeBefore    public boolean remove(T anEntry)    {        boolean found = false;        if (this.numberOfEntries > 0)        {            Node nodeToRemove;            Node nodeBefore = getNodeBefore(anEntry);            if (nodeBefore == null)                nodeToRemove = this.firstNode;            else                nodeToRemove = nodeBefore.next;            if ((nodeToRemove != null) && anEntry.equals(nodeToRemove.data))            {                found = true;                if (nodeBefore == null)                    this.firstNode = nodeToRemove.getNextNode();                else                {                    Node nodeAfter = nodeToRemove.next;                    nodeBefore.next = nodeAfter;                } // end if                this.numberOfEntries--;            } // end if        } // end if        return found;    } // end remove    public int getPosition(T anEntry)    {        int position = 1;        Node currentNode = this.firstNode;        while ((currentNode != null) && (anEntry.compareTo(currentNode.data) > 0))        {            currentNode = currentNode.next;            position++;        } // end while        if ((currentNode == null) || anEntry.compareTo(currentNode.data) != 0)            position = -position;        return position;    } // end getPosition    // list operations    public T remove(int givenPosition)    {        T result = null;                           // return value        if ((givenPosition >= 1) && (givenPosition <= this.numberOfEntries))        {            assert !isEmpty();            if (givenPosition == 1)                 // case 1: remove first entry            {                result = firstNode.data;        // save entry to be removed                this.firstNode = this.firstNode.next;            } else                                    // case 2: givenPosition > 1            {                Node nodeBefore = getNodeAt(givenPosition - 1);                Node nodeToRemove = nodeBefore.next;                Node nodeAfter = nodeToRemove.next;                // disconnect the node to be removed                nodeBefore.next = nodeAfter;                result = nodeToRemove.data;     // save entry to be removed            } // end if            this.numberOfEntries--;        } // end if        return result;                             // return removed entry, or        // null if operation fails    } // end remove    public final void clear()    {        this.firstNode = null;        this.numberOfEntries = 0;    } // end clear    public T getEntry(int givenPosition)    {        T result = null;  // result to return        if ((givenPosition >= 1) && (givenPosition <= this.numberOfEntries))        {            assert !isEmpty();            result = getNodeAt(givenPosition).data;        } // end if        return result;    } // end getEntry    public boolean contains(T anEntry)    {        boolean found = false;        Node currentNode = this.firstNode;        while (!found && (currentNode != null))        {            if (anEntry.equals(currentNode.data))                found = true;            else                currentNode = currentNode.next;        } // end while        return found;    } // end contains    public int getLength()    {        return this.numberOfEntries;    } // end getLength    public boolean isEmpty()    {        boolean result;        if (this.numberOfEntries == 0) // or getLength() == 0        {            assert this.firstNode == null;            result = true;        } else        {            assert this.firstNode != null;            result = false;        } // end if        return result;    } // end isEmpty    public boolean isFull()    {        return false;    } // end isFull    public T[] toArray()    {        // the cast is safe because the new array contains null entries        @SuppressWarnings("unchecked")        T[] result = (T[]) new Comparable[this.numberOfEntries]; // warning: [unchecked] unchecked cast        int index = 0;        Node currentNode = this.firstNode;        while ((index < this.numberOfEntries) && (currentNode != null))        {            result[index] = currentNode.data;            currentNode = currentNode.next;            index++;        } // end while        return result;    } // end toArray    private Node getNodeAt(int givenPosition)    {        assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= this.numberOfEntries);        Node currentNode = this.firstNode;        // traverse the list to locate the desired node        for (int counter = 1; counter < givenPosition; counter++)            currentNode = currentNode.next;        assert currentNode != null;        return currentNode;    } // end getNodeAt    private class Node    {        private T data; // entry in list        private Node next; // link to next node        private Node(T dataPortion)        {            this.data = dataPortion;            this.next = null;        } // end constructor        private Node(T dataPortion, Node nextNode)        {            this.data = dataPortion;            this.next = nextNode;        } // end constructor        private T getData()        {            return this.data;        } // end getData        private void setData(T newData)        {            this.data = newData;        } // end setData        private Node getNextNode()        {            return this.next;        } // end getNextNode        private void setNextNode(Node nextNode)        {            this.next = nextNode;        } // end setNextNode    } // end Node} // end SortedLinkedList