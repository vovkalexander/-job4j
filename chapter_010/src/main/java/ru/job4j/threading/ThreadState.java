package ru.job4j.threading;
/**
 * ThreadState.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        first.start();
        Thread second = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        second.start();
        while (Thread.currentThread().getState() != Thread.State.TERMINATED) {
            if (first.getState() == Thread.State.TERMINATED
                  && second.getState() == Thread.State.TERMINATED) {
                System.out.println(first.getState());
                System.out.println(second.getState());
                break;
            }

        }
        System.out.printf("%s%s%s", Thread.currentThread().getName(), " - the action is finished",
                System.lineSeparator());
    }
}
