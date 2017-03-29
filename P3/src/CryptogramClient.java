// Cryptogram Client
// Joshua Steward
// 10/29/2014

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CryptogramClient
{
    public static void main(String[] args)  throws IOException
    {
        Cryptogram cg = new Cryptogram();
        System.out.println(cg); // print alphabet and substitution code

        Scanner fromFile = new Scanner(new File("wish.txt"));
        while (fromFile.hasNext())
        {
            String phrase = fromFile.nextLine();
            System.out.println("\nThe original line is \t \"" + phrase + "\"");

            String code = cg.encrypt(phrase);

            System.out.println("The encrypted phrase is \t \"" + code + "\"");

            String plainText = cg.decrypt(code);

            System.out.println("The decrypted phrase is \t \"" + plainText + "\"");
        }
        System.out.println();
       // cg.displayStatistics();
    }
}