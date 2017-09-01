package ru.moskalets.iterator.task4;

import java.util.Iterator;

/**
 * The class implements the iterator of iterators.
 * author Igor Moskalets
 * Since 07.08.2017
 */
public class Converter {
    /**
     * An iterator consisting of iterators.
     */
    private Iterator<Iterator<Integer>> it;
    /**
     * iteratorTemp.
     */
    private Iterator<Integer> iteratorTemp;
    /**
     * The method returns one iterator that is composed of a plurality of iterators.
     * @param it An iterator consisting of iterators.
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
                boolean cheak = false;
                if (!Converter.this.it.hasNext()) {
                    if (Converter.this.iteratorTemp.hasNext()) {
                        cheak = true;
                    }
                } else {
                    cheak = true;
                }
                return cheak;
            }
            /**
             * The method returns the next element.
             * @return Integer.
             */
            @Override
            public Integer next() {
                Integer result;
                if (Converter.this.iteratorTemp == null) {
                    Converter.this.iteratorTemp = Converter.this.it.next();
                }
                if (Converter.this.iteratorTemp.hasNext()) {
                    result = Converter.this.iteratorTemp.next();
                } else {
                    Converter.this.iteratorTemp = Converter.this.it.next();
                    result = Converter.this.iteratorTemp.next();
                }
                return result;
            }
        };
    }
}
