package ru.moskalets.inputOutput;

import java.io.*;
import java.util.Scanner;

/**
 * ServiceDropAbuses - remove the forbidden words.
 * @author Igor Moskalets
 * @since 28.02.2017.
 */
public class ServiceDropAbuses {
    /*
    * The method deletes the forbidden words.
    * @param IntputStream in.
    * @param OutputStream out.
    * @param String[] abuse.
    */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        PrintStream ps = new PrintStream(out);
        Scanner sc  = new Scanner(in);
        try {
            while (sc.hasNextLine()){
                String temp = sc.nextLine();
                for (String worldAbuse : abuse) {
                    temp = temp.replaceAll(worldAbuse, "");
                }
             ps.write(temp.getBytes());
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
           sc.close();
           ps.close();
        }
    }
}
