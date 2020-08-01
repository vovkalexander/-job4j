package ru.job4j.threading;
/**
 * Wget.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Wget {
    public static void main(String[] args) {
        Thread thread = new Thread (
                () -> {
                    try {
                        for (int index = 0; index <= 100; index++) {
                            Thread.sleep(1000);
                            System.out.print("\rLoading : " + index  + "%");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        thread.start();
    }
}
