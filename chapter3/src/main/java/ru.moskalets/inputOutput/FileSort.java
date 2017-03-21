package ru.moskalets.inputOutput;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * FileSort - reads from a file of strings, sorts them by length, writes to another file.
 * @author Igor Moskalets.
 * @since 21.03.2017.
 */
public class FileSort {
    /**
     * Method reads from a file of strings, sorts them by length, writes to another file.
     * @param File source.
     * @param File distance.
     * @return void.
     */
    public void sort(File source, File distance) throws IOException{
        ArrayList<String> tempStrings = new ArrayList<>();
        RandomAccessFile sourceFile = new RandomAccessFile(source, "r");
        RandomAccessFile distanceFile = new RandomAccessFile(distance, "rw");
        try {
            String lineTemp = sourceFile.readLine();
            while (lineTemp != null) {
                tempStrings.add(lineTemp);
                lineTemp = sourceFile.readLine();
            }
            tempStrings = sortList(tempStrings);
            for (String tempString : tempStrings) {
                distanceFile.write(tempString.getBytes());
                distanceFile.write("\n".getBytes());
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            sourceFile.close();
            distanceFile.close();
        }
    }
    /**
     * The method sorts the rows in ascending order of length.
     * @param ArrayList tempStrings.
     * @return ArrayList.
     */
    public ArrayList sortList(ArrayList tempStrings){
        Collections.sort(tempStrings,
                new Comparator<String>() {
                    public int compare(String o1, String o2) {
                        return o1.length() - o2.length();
                    }
                }
        );
        return tempStrings;
    }
}
