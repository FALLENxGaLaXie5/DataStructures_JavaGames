/** * PalindromeChecker * * @author Joshua Steward * @version 02/07/2015 */import java.util.Scanner;import java.util.Stack;public class PalindromeChecker{    /**     * Tests whether a string is a palindrome, ignoring punctuation, spaces, and case.     *     * @param input a string to check     */    public boolean isPalindrome(String input)    {        boolean result = true;        Stack<Character> charactersStack = new Stack<>();        input = input.replaceAll("[!?.,'\"/0-9]", "");        input = input.toLowerCase();        int startIterator = input.length()/2;        if (input.length() % 2 != 0)        {            startIterator++;        }        for (int i = 0; i < input.length()/2; i++)        {            charactersStack.push(input.charAt(i));        }        for (int i = startIterator; i < input.length() && result; i++)        {            if (!charactersStack.pop().equals(input.charAt(i)))            {                result = false;            }        }        return result;    } // end isPalindrome    public static void main(String[] args)    {        Scanner keyboard = new Scanner(System.in);        PalindromeChecker pc = new PalindromeChecker();        //Describe the program and how it works        System.out.println("*** This program determines whether a string is a palindrome. ");        System.out.println("A palindrome is spelled the same from left to right as it is from right to left,");        System.out.println("if we ignore punctuation, spaces, and case. ***");        System.out.println("\nEnter a string that you want to check (or enter \"stop\" to stop): ");        String input = keyboard.nextLine();        while (!input.equalsIgnoreCase("stop"))        {            if (pc.isPalindrome(input))                System.out.println("\"" + input + "\" is a palindrome!");            else                System.out.println("\"" + input + "\" is not a palindrome!");            System.out.println("\nEnter a string that you want to check (or enter \"stop\" to stop): ");            input = keyboard.nextLine();        } // end while        System.out.println("Done!");    } // end main} // end PalindromeChecker