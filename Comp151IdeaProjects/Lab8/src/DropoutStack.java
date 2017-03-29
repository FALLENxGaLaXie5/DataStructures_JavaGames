import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * A class of stacks whose entries are stored in a deque.
 * @author Joshua Steward
 * @version 3/3/2015
 */
public class DropoutStack<T>
{


    // IMPLEMENT ALL THE METHODS DEFINED IN THE UML DIAGRAM
    // UNCOMMENT THE display and main METHODS WHEN READY FOR TESTING

    private ArrayDeque<T> stack;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 20;

    /**
     * Default constructor: sets stack to the default capacity, and capicity to default capacity
     */
    public DropoutStack()
    {
        this.stack = new ArrayDeque<>(DEFAULT_CAPACITY);
        this.capacity = this.DEFAULT_CAPACITY;
    }

    /**
     * Constructor:
     * sets capacity to parameter
     * sets stack to a new ArrayDeque with the capacity set
     * @param capacity
     */

    public DropoutStack(int capacity)
    {
        this.capacity = capacity;
        this.stack = new ArrayDeque<>(this.capacity);
    }

    /**
     * Push
     * if it is full
     *      takes of last element
     *
     * pushes new object on stack
     * @param object
     */
    public void push(T object)
    {
        if (this.stack.size() == this.capacity)
        {
            this.stack.pollLast();
        }
        this.stack.push(object);
    }

    /**
     * Peek
     * returns top element without affecting stack
     * @return
     */
    public T peek()
    {
        return this.stack.peek();
    }


    /**
     * Pop
     * calls poll to pop top element
     * @return
     */
    public T pop()
    {
        return this.stack.poll();
    }

    /**
     * Calls isEmpty
     * @return
     */
    public boolean isEmpty()
    {
        return this.stack.isEmpty();
    }

    /**
     * Calls clear
     */
    public void clear()
    {
        this.stack.clear();
    }
    /**
     * METHOD display implemented for debugging purposes
     */
    public void display()
    {
        if (isEmpty())
            System.out.println("The stack is empty");
        else
            System.out.println(Arrays.toString(this.stack.toArray()));
    }

    public static void main(String args[])
    {
        System.out.println("**************  TESTING DROPOUT STACK  **************\n");
        DropoutStack<Integer> dropoutStack = new DropoutStack<Integer>();

        System.out.println("---->  Adding 20 items to empty stack of capacity of 20");
        for (int i = 0; i < 20; i++)
        {
            dropoutStack.push(i);
        }
        System.out.println("---->  The content of the stack is:");
        dropoutStack.display();
        System.out.println("----> The top of the stack is: " + dropoutStack.peek());
        System.out.println("\n----> Adding 5 more items to full stack");
        for (int i = 20; i < 25; i++)
        {
            System.out.println("push " + i);
            dropoutStack.push(i);
        }

        System.out.println("---->  The content of the stack is:");
        dropoutStack.display();
        System.out.println("----> The top of the stack is: " + dropoutStack.peek());

        System.out.println("\n---->  Removing all elements from the stack:");
        while (!dropoutStack.isEmpty())
        {
            System.out.println("----> pop " + dropoutStack.pop());
        }

        dropoutStack.display();
        System.out.println("----> The top of the stack is: " + dropoutStack.peek());

        System.out.println("\n----> Trying to pop from the empty stack");
        System.out.println("----> Got back " + dropoutStack.pop());

        System.out.println("\n----> Trying to peek at the top of the empty stack");
        System.out.println("----> Got back " + dropoutStack.peek());

        System.out.println("\n----> Adding 22 items to empty stack of capacity of 20");
        for (int i = 0; i < 22; i++)
        {
            dropoutStack.push(i);
        }
        System.out.println("---->  The content of the stack is:");
        dropoutStack.display();

        System.out.println("\n---->  Clearing the stack with the clear method");
        dropoutStack.clear();
        System.out.println("---->  The content of the stack is:");
        dropoutStack.display();
    }
} // end DropoutStack