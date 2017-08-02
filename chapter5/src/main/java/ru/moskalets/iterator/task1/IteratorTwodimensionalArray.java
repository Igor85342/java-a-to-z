package ru.moskalets.iterator.task1;
import java.util.Iterator;
/*/**
 * This class implements an iterator for a two-dimensional array.
 * author Igor Moskalets
 * Since 30.07.2017
 */
public class IteratorTwodimensionalArray implements Iterator {
    private final int[][] values;
    private int indexX = 0;
    private int indexY = 0;
    public IteratorTwodimensionalArray(int[][] values){
        this.values = values;
    }
    /**
     * This method checks whether the next element in the array.
     * @return boolean.
     */
    public boolean hasNext(){
        return ((this.values.length - 1 >= this.indexX) & (this.values[this.indexX].length > this.indexY));
    }
    /**
     * This method returns the next element of the array.
     * @return Object.
     */
    public Object next(){
        Object result = values[indexX][indexY] ;
        if (values[indexX].length-1 > this.indexY) {
            this.indexY++;
        } else {
            if (values.length -1 > indexX){
                this.indexX++;
                this.indexY = 0;
            } else {
                //this.indexX++;
                this.indexY ++; }
        }
        return result;
    }
}
