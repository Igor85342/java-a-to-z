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
                st1 = st1.concat("\\");
                st2 = st2.concat("\\");
                if (st1.substring(0, st1.indexOf("\\")).equals(st2.substring(0, st2.indexOf("\\")))) {
                    if (counter(st1) > 1 & counter(st2) > 1) {
                        flag = st2.compareTo(st1);
                    } else flag = st1.compareTo(st2);
                    if (counter(st1) >= 2 & counter(st2) >= 2) {
                        if (counter(st1) != counter(st2)) {
                            if (st1.substring(st1.indexOf("\\") + 1, st1.indexOf("\\",st1.indexOf("\\")+1)).equals(st2.substring(st2.indexOf("\\") + 1, st2.indexOf("\\",st2.indexOf("\\")+1)))) {
                                flag = st1.compareTo(st2);
                            }
                        }
                    }
                }
           return flag;
            }
            public int counter(String string){
                int replace = string.length() - string.replace("\\", "").length();
                return replace;
            }
        });
        return units;
    }
}
