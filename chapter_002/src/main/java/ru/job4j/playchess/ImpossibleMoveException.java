package ru.job4j.playchess;
/**
 * ImpossibleMoveException
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ImpossibleMoveException extends RuntimeException {
    /**
     * Метод реализаущий запрос параметров пользователя.
     * @param msg - сообщение на консоль о наличие исключения.
     */
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
