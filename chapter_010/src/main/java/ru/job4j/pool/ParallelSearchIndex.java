package ru.job4j.pool;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/**
 * ParallelSearchIndex.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ParallelSearchIndex extends RecursiveTask<Integer> {
    /**
     * Field - stores arrays of objects.
     */
    private final Object[] objects;
    /**
     * Field - stores integer of starting size of array.
     */
    private final int start;
    /**
     * Field - stores integer of final size of array.
     */
    private final int end;
    /**
     * Field - stores a object which looking for index .
     */
    private final Object o;
    /**
     * Constructor for activation fields.
     */

    public ParallelSearchIndex(Object[] objects, int start, int end, Object o) {
        this.objects = objects;
        this.start = start;
        this.end = end;
        this.o = o;

    }

    @Override
    protected Integer compute() {
        int size = end - start + 1;
        if (size <= 10) {
            return processSearch();
        }
        int mid = (end + start) / 2;
        ParallelSearchIndex task1 = new ParallelSearchIndex(objects, start, mid, o);
        ParallelSearchIndex task2 = new ParallelSearchIndex(objects, mid + 1, end, o);
        task1.fork();
        task2.fork();
        int left = task1.join();
        int right = task2.join();
        return left > right ? left : right;
    }
    /**
     * The method turns over array for finding index.
     * @return index.
     */

    private final Integer processSearch() {
        int  count = 0;
        for (int i = start; i <= end; i++) {
            if (objects[i].equals(o)) {
                count = i;
                return count;
            }
        }
        return -1;
    }
    /**
     * The method creates parallel to threads in order to find index.
     * @return index.
     */

    public static Integer indexOf(Object[] objects, Object o) {
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(new ParallelSearchIndex(objects, 0, objects.length - 1, o));
    }
}



