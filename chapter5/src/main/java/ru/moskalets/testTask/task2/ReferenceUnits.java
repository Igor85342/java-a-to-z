package ru.moskalets.testTask.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorts the elements in ascending or descending order.
 * author Igor Moskalets
 * Since 05.07.2017
 */
public class ReferenceUnits {
    public ReferenceUnits(){
    }
    /**
     * Sorts the elements in ascending order.
     * @param List<String> units.
     * @return List<String>.
     */
    public List<String> sortAscending(List<String> units){
        Collections.sort(units, new Comparator<String>() {
            public int compare(String st1, String st2){
                return st1.compareTo(st2);
            }
        });
        return units;
    }
    /**
     * Sorts the elements in descending order.
     * @param List<String> units.
     * @return List<String>.
     */
    public List<String> sortDescending(List<String> units){
        Collections.sort(units, new Comparator<String>(){
            public int compare(String st1, String st2){
                int flag;
                flag = st2.compareTo(st1);
                if (st1.substring(0,2).equals(st2.substring(0,2))){
                    if (st1.length() > 2 && st2.length() > 2){
                        flag = st2.compareTo(st1);
                    } else flag = st1.compareTo(st2);
                    if (st1.length() >= 6 && st2.length() >= 6 ) {
                            if (st1.length() != st2.length()) {
                                if (st1.substring(0, 6).equals(st2.substring(0, 6))) {
                                    flag = st1.compareTo(st2);
                                }
                            }
                    }
                }
           return flag;
            }
        });
        return units;
    }
}
