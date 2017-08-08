package ru.moskalets.iterator.task4;

import java.util.Iterator;

/**
 * The class implements the iterator of iterators.
 * author Igor Moskalets
 * Since 07.08.2017
 */
public class Converter {
    Iterator <Iterator<Integer>> it;
    Iterator<Integer> iterator;
    /**
     * The method returns one iterator that is composed of a plurality of iterators.
     * @param Iterator<Iterator<Integer>> it.
     * @return Iterator<Integer>.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.it = it;
        return new Iterator<Integer>() {
            /**
             * The method checks whether the next element.
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                return Converter.this.it.hasNext();
            }
            /**
             * The method returns the next element.
             * @return Integer.
             */
            @Override
            public Integer next() {
                Integer result;
                if (Converter.this.iterator == null){
                     iterator = Converter.this.it.next();
                } if (iterator.hasNext()){
                    result = iterator.next();
                } else {
                    iterator = Converter.this.it.next();
                    result = iterator.next();
                }
                return result;
            }
        };
    }
}
