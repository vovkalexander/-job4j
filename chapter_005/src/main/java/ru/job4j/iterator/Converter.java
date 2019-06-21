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
     *
     * @param it итератор итераторов целых чисел.
     * @return объединенный итератор.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> currentIt;
            @Override
            public boolean hasNext() {
                while (currentIt == null || !currentIt.hasNext()) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    currentIt = it.next();
                }
                return true;
            }
            @Override
            public Integer next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return currentIt.next();
            }

        };
    }
}
