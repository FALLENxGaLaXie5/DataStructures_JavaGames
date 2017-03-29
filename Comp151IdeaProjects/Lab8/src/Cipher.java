/**
 * A class that implements a cipher with repeating key algorithm.
 *
 * @author Joshua Steward
 * @version 03/3/2015
 */


public class Cipher
{
    private QueueInterface<Integer> keyQueueE;
    private QueueInterface<Integer> keyQueueD;
    private int[] key;

    /**
     * First, instantiates key from paramter key
     * Next, sets both keys that will be used to this key
     * Copies them into both keys
     * @param key
     */
    public Cipher(int... key)
    {
        this.key = key;
        this.keyQueueE = new CircularArrayQueue<>(this.key.length);
        this.keyQueueD = new CircularArrayQueue<>(this.key.length);
        for (int i = 0; i < this.key.length; i++)
        {
            this.keyQueueE.enqueue(this.key[i]);
            this.keyQueueD.enqueue(this.key[i]);
        }
    }

    /**
     * Encode
     * Instantiates encoded message as a new string
     * for each character
     *      sets the currentChar as the character currently at
     *      sets the currentCode as the dequeued code from the key
     *      gets ascii value and adds key value to it
     *      sets it back to character representation from ascii
     *      enqueues key back to the end of the key
     * returns string
     * @param message
     * @return
     */
    public String encode(String message)
    {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < message.length(); i++)
        {
            char currentChar = message.charAt(i);
            int currentCode = this.keyQueueE.dequeue();
            int ascii = (int)currentChar;
            ascii += currentCode;
            currentChar = (char)ascii;
            encoded.append(currentChar);
            this.keyQueueE.enqueue(currentCode);
        }
        return encoded.toString();
    }

    /**
     * Decode
     * instantiates decoded message
     * For each character, does the same as encode but backwards and using keyQueueD instead
     * @param encoded
     * @return
     */
    public String decode(String encoded)
    {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < encoded.length(); i++)
        {
            char currentChar = encoded.charAt(i);
            int currentCode = this.keyQueueD.dequeue();
            int ascii = (int)currentChar;
            ascii -= currentCode;
            currentChar = (char)ascii;
            decoded.append(currentChar);
            this.keyQueueD.enqueue(currentCode);
        }
        return decoded.toString();
    }


    public static void main(String args[])
    {
        System.out.println("**************  TESTING THE CIPHER  **************\n");
        Cipher cipher = new Cipher(5, 12, -3, 8, -9, 4, 10);
        String encoded = cipher.encode("All programmers are playwrights and all computers are lousy actors.");
        System.out.println("--->The original message encoded is:");
        System.out.println(encoded);
        String decoded = cipher.decode(encoded);
        System.out.println("--->The original message decoded is:");
        System.out.println(decoded);

        encoded = cipher.encode("There is no elevator to success, You have to take the stairs...");
        System.out.println("\n--->The original message encoded is:");
        System.out.println(encoded);
        decoded = cipher.decode(encoded);
        System.out.println("--->The original message decoded is:");
        System.out.println(decoded);

        cipher = new Cipher(3, 1, 7, 4, 2, 5);
        encoded = cipher.encode("knowledge is power");
        System.out.println("\n--->The original message encoded is:");
        System.out.println(encoded);
        decoded = cipher.decode(encoded);
        System.out.println("--->The original message decoded is:");
        System.out.println(decoded);

        cipher = new Cipher(3, 1, 7, 4, 2, 5);
        encoded = cipher.encode("race car");
        System.out.println("\n--->The original message encoded is:");
        System.out.println(encoded);
        decoded = cipher.decode(encoded);
        System.out.println("--->The original message decoded is:");
        System.out.println(decoded);
    }
} // end DropoutStack


