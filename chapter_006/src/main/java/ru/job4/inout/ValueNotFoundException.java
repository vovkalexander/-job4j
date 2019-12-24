package ru.job4.inout;
/**
 * UnsupportedOperationException
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ValueNotFoundException extends Exception {
    /**
     * Метод реализаущий запрос параметров пользователя.
     * @param msg - сообщение на консоль о наличие исключения.

     */
    public ValueNotFoundException(String msg) {
        super(msg);
    }
}
