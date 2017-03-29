//Weekday Birthday Calculator
//Joshua Steward
package com.company;
import java.util.Scanner;
public class WeekDayCalc
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner ( System.in );
        System.out.print("Please enter the day of the month of birthday: ");
        int bDay = scan.nextInt();
        System.out.print("Please enter the month of birthday: ");
        String bMonth = scan.next();
        System.out.print("Please enter the year of birthday: ");
        int bYear = scan.nextInt();
        //Step 1
        int bYear1 = (bYear % 100)/ 12;
        int bYearRest = (bYear % 100) % 12;

        //Step 2
        int bYear2 = (bYearRest) + bYear1;
        //Step 3
        int bYear3 = bYearRest / 4;
        //Step 4
        int bYear4 = bYear3 + bYear2;
        //Step 5
        int bYear5 = bDay + bYear4;

        //Step 6

        switch (bMonth)
        {
            case "January":
            case "October":
                bYear5 = bYear5 + 1;
                break;
            case "February":
            case "March":
            case "November":
                bYear5 = bYear5 + 4;
                break;
            case "April":
            case "July":
                bYear5 = bYear5 + 0;
                break;
            case "May":
                bYear5 = bYear5 + 2;
                break;
            case "June":
                bYear5 = bYear5 + 5;
                break;
            case "August":
                bYear5 = bYear5 + 3;
                break;
            case "September":
            case "December":
                bYear5 = bYear5 + 6;
                break;
            default:
                bYear5 = bYear5 + 0;

        }

        if (((bYear % 4 == 0 && !(bYear % 100 == 0))
                || (bYear % 400 == 0)) && (bMonth.equals("January")
                || bMonth.equals("February")))
        {
            bYear5 --;
        }

        //Step 7
        if (bYear >= 2000)
        {
            bYear5--;
        }
        else if (bYear < 1900)
        {
            bYear5 = bYear5 + 2;
        }
        else
        {
            bYear5 = bYear5 + 0;
        }
        String out = "";
        int fin = bYear5 % 7;

        switch (fin)
        {
            case 0:
                out = "Saturday";
                break;
            case 1:
                out = "Sunday";
                break;
            case 2:
                out = "Monday";
                break;
            case 3:
                out = "Tuesday";
                break;
            case 4:
                out = "Wednesday";
                break;
            case 5:
                out = "Thursday";
                break;
            case 6:
                out = "Friday";
                break;
            default:
                out = "Unknown";

        }
        System.out.println("This day is " + out + ".");


    }
}
