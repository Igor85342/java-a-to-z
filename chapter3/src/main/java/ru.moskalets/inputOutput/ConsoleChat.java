package ru.moskalets.inputOutput;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * ConsoleChat - an object of this class allows you to enter a phrase and get back a random phrase from a file.
 * @author Igor Moskalets.
 * @since 07.04.2017.
 */
public class ConsoleChat {
    private final String source;
    private final String distance;
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    public ConsoleChat(String source, String distance) {
    this.source = source;
    this.distance = distance;
    }
    public static void main(String[] args) throws IOException {
        String source = "C:\\Projects\\java-a-to-z\\chapter3\\src\\main\\java\\ru.moskalets\\inputOutput\\phrasesForChat.txt";
        String distance = "C:\\Projects\\java-a-to-z\\chapter3\\src\\main\\java\\ru.moskalets\\inputOutput\\log.txt";
        ConsoleChat cc = new ConsoleChat(source,distance);
        cc.consoleChat();
    }
    /**
     * The method implements the chat.
     * @return void.
     */
    public void consoleChat() throws IOException {
        RandomAccessFile distanceFile = new RandomAccessFile(new File(this.distance), "rw");
        try {
            String inputString="";
            boolean stopFlag = false;
            String outputString;
            while (inputString.compareToIgnoreCase("Exit") != 0) {
                inputString = scanner.nextLine();
                if (inputString.compareToIgnoreCase("stop") == 0){
                    stopFlag = true;
                }
                if (inputString.compareToIgnoreCase("continue") == 0){
                    stopFlag = false;
                }
                if (stopFlag == false & inputString.compareToIgnoreCase("Exit") != 0 ) {
                    outputString = getPhrase();
                    System.out.println(outputString);
                    distanceFile = writingToFile(distanceFile, inputString, outputString);
                }
                if (stopFlag == true & inputString.compareToIgnoreCase("Exit") != 0 ) {
                    distanceFile = writingToFile(distanceFile, inputString);
                }
                if (inputString.compareToIgnoreCase("Exit") == 0) {
                    break;
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            distanceFile.close();
        }
    }
    /**
     * The method writes strings to a file.
     * @param RandomAccessFile distanceFile.
     * @param String inputString.
     * @param String outputString.
     * @return RandomAccessFile.
     */
    public RandomAccessFile writingToFile(RandomAccessFile distanceFile, String inputString, String outputString) throws IOException {
        distanceFile.write(inputString.getBytes());
        distanceFile.write("\n".getBytes());
        distanceFile.write(outputString.getBytes());
        distanceFile.write("\n".getBytes());
        return distanceFile;
    }
    /**
     * The method writes strings to a file.
     * @param RandomAccessFile distanceFile.
     * @param String inputString.
     * @return RandomAccessFile.
     */
    public RandomAccessFile writingToFile(RandomAccessFile distanceFile, String inputString) throws IOException {
        distanceFile.write(inputString.getBytes());
        distanceFile.write("\n".getBytes());
        return distanceFile;
    }
    /**
     * The method returns a random string from a file.
     * @return String.
     */
    public String getPhrase() throws IOException {
        ArrayList<String> tempStrings = new ArrayList<>();
        RandomAccessFile sourceFile = new RandomAccessFile(new File(this.source), "r");
        try {
            String lineTemp = sourceFile.readLine();
            while (lineTemp != null) {
                tempStrings.add(lineTemp);
                lineTemp = sourceFile.readLine();
            }

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            sourceFile.close();
        }
        return tempStrings.get(this.random.nextInt(tempStrings.size()));
    }
}
