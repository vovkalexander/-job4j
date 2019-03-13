package ru.job4j.playchess;
/**
 * FigureNotFoundException
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class OccupiedWayException extends RuntimeException {
    /**
     * Метод реализаущий запрос параметров пользователя.
     * @param msg - сообщение на консоль о наличие исключения.
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
