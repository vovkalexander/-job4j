package ru.job4j.threading;
/**
 * ConcurrentOutput.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ConcurrentOutput {
    public static void main(String[] args) {
        Thread another = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        another.start();
        System.out.println(Thread.currentThread().getName());
        Thread second = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        second.start();
    }
}
