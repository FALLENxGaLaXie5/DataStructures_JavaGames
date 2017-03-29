/**
 *  Write a recursive method that returns the smallest integer in an array of integers.
 *
 *  If you divide the array into two pieces - halves, for example - and find the smallest integer
 *  in each of the pieces, the smallest integer in the entire array will be the smaller
 *  of these two integers. Since you will be searching a portion of the array - for example, the elements
 *  array[first] through array[last] - it will be convenient for your method to have three parameters:
 *  the array and two indices, first and last.
 *  NOTE: You can refer to the method displayArray in Segment 7.18 in the textbook for the inspiration
 *
 * @author Anna Bieszczad
 * @version 02/12/2015
 */
public class MinInArray
{
    /** Task: Recursively finds the smallest value in an array of integers.
     * @param data an integer array
     * @param first the location to start looking for the minimum
     * @param last the location to stop looking for the minimum
     * first <= last
     */
    public static int minimum(int[] data, int first, int last)
    {
        int result = 0;  // THIS IS A STUB

        // IMPLEMENT THE METHOD

        // STEP #1 validate the input, if incorrect throw BadArgumentsForMinimumException



        // STEP #2 base case: first and last are the same



        // STEP #3 recursive case

        // recursively find minimum in each half


        // set result to the smallest of the two

        return result;
    } // end minimum

    public static void main(String args[])
    {
        MinInArray tester = new MinInArray();
        tester.testForExceptions();
        tester.testGoodValues();
    }

    public void testForExceptions()
    {
        System.out.println("TESTING TO SEE IF IT CATCHES BAD ARGUMENTS");

        MinInArray rm = new MinInArray();
        System.out.println("Trying a null array");
        int array[] = null;
        try
        {
            rm.minimum(array, 0, 0);
            System.out.println("*** Failed test (did not throw exception)");
        }
        catch(BadArgumentsForMinimumException e)
        {
            System.out.println("    Passed test");
        }


        System.out.println("Trying an array of size 0");
        array = new int[0];
        try
        {
            rm.minimum(array, 0, 0);
            System.out.println("*** Failed test (did not throw exception)");
        }
        catch(BadArgumentsForMinimumException e)
        {
            System.out.println("    Passed test");
        }

        System.out.println("Trying from less than 0");
        array = new int[5];
        try
        {
            rm.minimum(array, -1, 0);
            System.out.println("*** Failed test (did not throw exception)");
        }
        catch(BadArgumentsForMinimumException e)
        {
            System.out.println("    Passed test");
        }


        System.out.println("Trying to greater than size");
        try
        {
            rm.minimum(array, 0, 5);
            System.out.println("*** Failed test (did not throw exception)");
        }
        catch(BadArgumentsForMinimumException e)
        {
            System.out.println("    Passed test");
        }


        System.out.println("Trying from > to");
        try
        {
            rm.minimum(array, 1, 0);
            System.out.println("*** Failed test (did not throw exception)");
        }
        catch(BadArgumentsForMinimumException e)
        {
            System.out.println("    Passed test");
        }

        System.out.println();
        System.out.println();

    }


    public void testGoodValues()
    {
        System.out.println("TESTING TO SEE IF IT GETS THE CORRECT RESULTS");

        MinInArray rm = new MinInArray();
        int array[] = {4};
        int result;

        System.out.println("Trying an array of size 1");
        result = rm.minimum(array, 0, 0);
        if(result==4)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 4");

        System.out.println("Trying an array of size 2, the same elements");
        int array2s[] = {2, 2};
        result = rm.minimum(array2s, 0, 1);
        if(result==2)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 2");

        System.out.println("Trying an array of size 2, second is smallest");
        int array2[] = {3, 2};
        result = rm.minimum(array2, 0, 1);
        if(result==2)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 2");

        System.out.println("Trying an array of size 2, first is smallest");
        int array3[] = {3, 4};
        result = rm.minimum(array3, 0, 1);
        if(result==3)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 3");


        System.out.println("Trying an array of size 3, first is smallest");
        int array4[] = {3, 10, 4};
        result = rm.minimum(array4, 0, 2);
        if(result==3)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 3");


        System.out.println("Trying an array of size 3, second is smallest");
        int array5[] = {10, 4, 13};
        result = rm.minimum(array5, 0, 2);
        if(result==4)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 4");

        System.out.println("Trying an array of size 3, third is smallest");
        int array6[] = {10, 13, 4};
        result = rm.minimum(array6, 0, 2);
        if(result==4)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 4");


        System.out.println("Trying an array of size 20 (look at all values)");
        int array7[] = {10, 113, 25, 10, 35, 14, 29, 13, 14, 110, 13, 17, 34, 83, 9, 32, 44, 12, 90, 2};
        result = rm.minimum(array7, 0, 19);
        if(result==2)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expected value of 2");

        System.out.println("Trying an array of size 20 (look at first third)");
        result = rm.minimum(array7, 0, 6);
        if(result==10)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expected value of 10");

        System.out.println("Trying an array of size 20 (look at second third)");
        result = rm.minimum(array7, 7, 13);
        if(result==13)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expected value of 13");

        System.out.println("Trying an array of size 20 (look at last third excluding the last value)");
        result = rm.minimum(array7, 13, 18);
        if(result==9)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expected value of 9");

        System.out.println();
        System.out.println();
    }
}
