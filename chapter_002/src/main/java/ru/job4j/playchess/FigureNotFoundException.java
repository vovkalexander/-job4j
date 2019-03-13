package ru.job4j.playchess;
/**
 * FigureNotFoundException
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class FigureNotFoundException extends RuntimeException {
    /**
     * Метод реализаущий запрос параметров пользователя.
     * @param msg - сообщение на консоль о наличие исключения.
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
