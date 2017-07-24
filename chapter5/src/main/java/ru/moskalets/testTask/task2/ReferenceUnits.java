package ru.moskalets.testTask.task2;
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
                Dep st1Arr = new Dep(st1.split("\\\\"));
                Dep st2Arr = new Dep(st2.split("\\\\"));
                if (st1Arr.getDeps()[0].equals(st2Arr.getDeps()[0])){
                    if (st1Arr.getLength() > 1 & st2Arr.getLength() > 1 ){
                        flag = st2.compareTo(st1);
                    } else flag = st1.compareTo(st2);
                    if (st1Arr.getLength() >= 2 & st2Arr.getLength() >= 2 ) {
                        if (st1Arr.getLength() != st2Arr.getLength()) {
                            if (st1Arr.getDeps()[1].equals(st2Arr.getDeps()[1])) {
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
