package ru.job4j.tracker;
/**
 * MenuOutException.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class MenuOutException extends RuntimeException {
    /**
     * Метод реализаущий запрос параметров пользователя.
     * @param msg - сообщение на консоль о наличие исключения.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}