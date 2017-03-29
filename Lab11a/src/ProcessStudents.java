/**
 * Created by Joshua on 11/24/2014.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProcessStudents
{
    public static void main( String [] args)
    {
        ArrayList<StudentRecord> list = new ArrayList<StudentRecord>();
        try
        {
            File file = new File("studentsInput.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine())
            {
                String nextLine = scan.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(nextLine, "&");
                StudentRecord student = new StudentRecord();
                student.setName(tokenizer.nextToken());
                student.setId(tokenizer.nextToken());
                student.setPassword(tokenizer.nextToken());
                student.setGpa(Double.parseDouble(tokenizer.nextToken()));
                list.add(student);
            }
            FileOutputStream stream = new FileOutputStream("FileOutput.txt", true);
            PrintWriter writer = new PrintWriter(stream);
            for(int i = 0; i < list.size(); i++)
            {
                writer.print(i + " ");
                writer.print(list.get(i).toString());
                writer.println();
            }
        }
        catch (Exception e)
        {
            System.out.println("I Broke");
            System.out.print(e.toString());
        }
    }
}
