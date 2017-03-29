//Year Op
//Joshua Stewa
//
package com.company;

import java.util.Scanner;

public class YearOp
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.print("Enter year here: ");
        String year = scan.next();
        int num = year.length();

        switch (num)
        {
            case 2:
                int year1 = Integer.parseInt(year);
                year1 = year1 + 2000;
                System.out.println(year1);
                break;
            case 4:
                year1 = Integer.parseInt(year);
                System.out.println(year1);
                break;
            default:
                System.out.println("The year is not valid.");
        }

    }
}
