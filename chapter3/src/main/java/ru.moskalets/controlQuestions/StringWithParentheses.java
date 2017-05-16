package ru.moskalets.controlQuestions;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * StringWithParetheses - the class adds to a string closing parenthesis.
 * @author Igor Moskalets
 * @since 16.05.2017
 */
public class StringWithParentheses {
    /**
     * The main method of the runStringWithParentheses.
     * Takes the value from the incoming stream and
     * writes it after processing to the output stream.
     * @param InputStream in.
     * @param OutputStream out.
     * @return void.
     */
    public void runStringWithParentheses(InputStream in, OutputStream out) throws IOException {
        PrintStream ps = new PrintStream(out);
        Scanner sc  = new Scanner(in);
        try {
            while (sc.hasNextLine()){
                String temp = sc.nextLine();
                temp = formatString(temp);
                ps.write(temp.getBytes());
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            ps.close();
            sc.close();
        }
    }
    /**
     * Adds the closing parentheses to a string.
     * @param String temp.
     * @return String.
     */
    public String formatString(String temp){
        int leftParenthesesCount = countingOccurrencesCharacter(temp,'(');
        int rightParenthesesCount = countingOccurrencesCharacter(temp,')');
        if (leftParenthesesCount != rightParenthesesCount) {
            if (leftParenthesesCount > rightParenthesesCount) {
                for (int i = 0; i < (leftParenthesesCount - rightParenthesesCount); i++) {
                    temp = temp + ")";
                }
            } else {
                for (int i = 0; i < (rightParenthesesCount - leftParenthesesCount); i++) {
                    temp = "(" + temp;
                }
            }
        }
        return temp;
    }
    /**
     * Counts how many times the character in the string.
     * @param String temp.
     * @param char ch.
     * @return int.
     */
    public int countingOccurrencesCharacter(String temp,char ch) {
        int count = 0;
        for (int i=0;i < temp.length();i++){
            if (temp.charAt(i)==ch) count++;
        }
        return count;
    }
}
