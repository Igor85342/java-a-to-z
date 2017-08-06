package ru.moskalets.iterator.task3;
import java.util.Iterator;
/**
 * This class implements an iterator that returns Prime numbers.
 * author Igor Moskalets
 * Since 06.08.2017
 */
public class IteratorPrimeNumbers implements Iterator {
    private final int[] value;
    private int index;
    public IteratorPrimeNumbers(int[] value){
        this.value = value;
    }
    /**
     * This method checks whether after the index in the array primes.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        boolean cheak = false;
        for (int i = index; i < this.value.length; i++){
            if (thisPrimeNumber(this.value[i])){
                cheak = true;
                break;
            }
        }
        return cheak;
    }
    /**
     * This method returns the next Prime number.
     * @return boolean.
     */
    @Override
    public Object next() {
        while (thisPrimeNumber(this.value[this.index])==false){
            this.index++;
        }
        return this.value[this.index++];
    }
    /**
     * This method checks whether a number is Prime.
     * @param int number.
     * @return boolean.
     */
    public boolean thisPrimeNumber(int number){
        int cheak = 0;
        for (int i=1; i!=number; i++){
            if (number%i == 0 ){
                cheak++;
            }
        }
        return cheak <=1;
    }
}
