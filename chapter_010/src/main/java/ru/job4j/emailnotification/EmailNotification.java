package ru.job4j.emailnotification;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * EmailNotification.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class EmailNotification {
    /**
     * Field - stores object of ExecutorService with activated several threads equaling quality processors.
     */
    private final ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors());
    /**
     * The method sends email by means of pool of threads.
     * @param user .
     */

    public void emailTo(User user) {
        pool.submit(() -> {
            String subject = String.format("Notification %s to email %s",
                    user.getUsername(), user.getEmail());
            String body = String.format("Add a new event to %s", user.getUsername());
            this.send(subject, body, user.getEmail());
        });
    }
    /**
     * The method closes down pool.
     */

    public void close() {
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * The empty method
     *  @param subject - notification .
     *  @param body -  new event .
     *  @param email - user's email .
     */

    public void send(String subject, String body, String email) {

    }
}
