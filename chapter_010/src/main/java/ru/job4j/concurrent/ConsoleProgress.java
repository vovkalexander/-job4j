package ru.job4j.concurrent;
/**
 * ConsoleProgress.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ConsoleProgress implements Runnable {
    @Override
    public void run() {
        char[] process = new char[]{'-', '\\', '|', '/'};
        int index = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.print("\r load: " + process[index++]);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (index == 4) {
                index = 0;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(1000);
        progress.interrupt();
    }
}
