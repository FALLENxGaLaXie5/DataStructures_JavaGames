/**
 * Created by ania on 3/3/15.
 * Joshua Steward
 */

import java.util.Queue;

public class CircularArrayQueue<T> implements QueueInterface<T>
{
    private T[] queue; // Circular array of queue entries and one unused location
    private int frontIndex; // Index of front entry
    private int backIndex;  // Index of back entry
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 3;
    private static final int MAX_CAPACITY = 10000;

    public CircularArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public CircularArrayQueue(int initialCapacity)
    {
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        this.queue = tempQueue;
        this.frontIndex = 0;
        this.backIndex = initialCapacity;
        this.initialized = true;
    } // end constructor

    public void enqueue(T newEntry)
    {
        this.ensureCapacity();
        this.backIndex = (this.backIndex + 1) % this.queue.length;
        this.queue[backIndex] = newEntry;
    } // end enqueue

    public T getFront()
    {
        T result = null;
        if (this.queue[frontIndex] != null)
        {
            result = this.queue[frontIndex];
        }
        return result;
    } // end getFront

    public T dequeue()
    {
        T result = null;
        if (this.queue[frontIndex] != null)
        {
            result = this.queue[frontIndex];
            this.frontIndex = (this.frontIndex + 1) % this.queue.length;
        }
        return result;
    } // end dequeue

    public boolean isEmpty()
    {
        return this.frontIndex == ((this.backIndex + 1) % this.queue.length);  // THIS IS A STUB
    } // end isEmpty

    public void clear()
    {
        // null out only the used slots
        int frontI = this.frontIndex;
        for (int i = 0; i < this.queue.length - 1; i++)
        {
            this.queue[frontI] = null;
            frontI = (frontI + 1) % this.queue.length;
        }
        this.frontIndex = 0;
        this.backIndex = 0;
    } // end clear


    // Throws an exception if this object is not initialized.
    private void checkInitialization()
    {
        if (!initialized)
            throw new SecurityException("CircularArrayQueue object is not initialized properly.");
    } // end checkInitialization

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a queue " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
    } // end checkCapacity

    // Doubles the size of the array queue if it is full.
    // Precondition: checkInitialization has been called.
    private void ensureCapacity()
    {
        this.checkInitialization();
        if (this.frontIndex == (this.backIndex + 2) % this.queue.length)
        {
            T[] old = this.queue;
            int oldSize = old.length;
            T[] tempArray = (T[]) new Object[oldSize * 2];
            this.queue = tempArray;
            for (int i = 0; i < oldSize - 1; i++)
            {
                this.queue[i] = old[this.frontIndex];
                this.frontIndex = (this.frontIndex + 1) % oldSize;
            }
            this.frontIndex = 0;
            this.backIndex = oldSize - 2;
        }
    } // end ensureCapacity
    public static void main(String args[])
    {
        QueueInterface line = new CircularArrayQueue(5);
        line.enqueue(12);
        line.enqueue(10);
        line.enqueue(11);
        line.enqueue(5);
        line.enqueue(10);
        line.enqueue(11);
        System.out.println("First entry is " + line.getFront());
    }
}

