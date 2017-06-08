package ru.moskalets.collectionsFramework.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * The class allows to convert array to list and back.
 * author Igor Moskalets
 * Since 07.06.2017
 */
public class ConvertList {
    /**
     * The method converts the array to a list.
     * @param int[][] array.
     * @return List<Integer></>.
     */
    public List<Integer> toList(int[][] array) {
        ArrayList<Integer> finalList = new ArrayList();
        for (int i=0; i < array.length;i++) {
            for (int j=0; j < array[0].length; j++){
                finalList.add(array[i][j]);
            }
        }
        return finalList;
    }
    /**
     * The method converts the list to an array with the specified number of rows.
     * All rows are filled. If not enough elements in the array, zeros are added.
     * @param List<Integer> list.
     * @param int rows.
     * @return int[][].
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int column = list.size()/rows;
        if ((list.size() % rows) != 0){
            column++;
        }
        int[][] finalArray = new int[rows][column];
        Iterator<Integer> iterator = list.iterator();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < column; j++) {
                    if (iterator.hasNext()) {
                        finalArray[i][j] = iterator.next();
                    }
                }
            }
        return finalArray;
    }
}
