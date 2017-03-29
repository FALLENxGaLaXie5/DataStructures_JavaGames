//Web Address
//Joshua Steward
//package com.company;

import java.util.Scanner;

public class WebAddress
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );

        System.out.print("Enter web address: ");

        String address = scan.nextLine();
        String res = "";

        String dom = "";

        dom = address.substring(address.lastIndexOf('.') + 1, address.length());

        switch (dom)
        {
            case "gov":
                res = "This is a government web address.";
                break;
            case "edu":
                res = "This is a university web address.";
                break;
            case "com":
                res = "This is a business web address.";
                break;
            case "org":
                res = "This is an organization web address.";
                break;
            default:
                res = "This is a web address for some other entity.";

        }
        System.out.println(res);
    }
}
