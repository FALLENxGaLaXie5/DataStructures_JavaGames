//Password Matcher
//Joshua Steward
package com.company;

import java.util.Scanner;

public class PasswordMatcher
{

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner( System.in );
        System.out.print("Enter password here: ");
        String pass1 = scan.next();
        System.out.print("Retype password: ");
        String pass2 = scan.next();
        if (pass1.equals(pass2))
        {
            System.out.println("You are now registered as a new user.");
        }
        else
        {
            System.out.print("Sorry, there is a typo in your password.");
        }
    }
}
