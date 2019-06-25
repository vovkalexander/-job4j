package ru.job4j.generic;
import java.util.Iterator;
/**
 * AbstractStore.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;
    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }
    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }
    @Override
    public boolean replace(String id, T model) {
        boolean rst = false;
        Iterator it = simpleArray.iterator();
        for (int i = 0; it.hasNext(); i++) {
            T value = (T) it.next();
            if (value.getId().equals(id)) {
                simpleArray.set(i, model);
                rst = true;
                break;
            }
        }
        return rst;
    }
    @Override
    public boolean delete(String id) {
        boolean rst = false;
        Iterator it = simpleArray.iterator();
        for (int i = 0; it.hasNext(); i++) {
            T value = (T) it.next();
            if (value.getId().equals(id)) {
                rst = true;
                simpleArray.remove(i);
                break;
            }
        }
        return rst;
    }
    @Override
    public T findById(String id) {
        T rst = null;
        for (T value : this.simpleArray) {
            if (value.getId().equals(id)) {
                rst = value;
                break;
            }
        }
        return rst;
    }
}

