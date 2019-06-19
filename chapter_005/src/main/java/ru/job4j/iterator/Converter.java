package ru.job4j.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Converter.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Converter {
    /**
     * Преобразовывает  итератор итераторов в один итератор
     * @param it итератор итераторов целых чисел.
     * @return  объединенный итератор.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> currentIt;
            @Override
            public boolean hasNext() {
                if (currentIt == null && it.hasNext()) {
                    currentIt = it.next();
                }
                if(currentIt == null){
                    return false;
                }
                if(currentIt.hasNext()) {
                    return true;
                }
                if(it.hasNext()) {
                    currentIt = it.next();
                }
                return currentIt.hasNext();
            }
            @Override
            public Integer next() {
                if (currentIt == null && it.hasNext()) {
                    currentIt = it.next();
                }
                if(currentIt == null) {
                    throw new NoSuchElementException();
                }
                if(!currentIt.hasNext() && it.hasNext()){
                    currentIt = it.next();
                }
                return currentIt.next();
            }
        };
    }
}
