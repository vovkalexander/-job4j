package ru.job4j.cofeemashine;
/**
 * NotEnoughMoney.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class NotEnoughMoney extends RuntimeException {
    /**
     * Конструктор - наследует конструктор родителя.
     * @param msg - сообщение на консоль о наличие исключения.
     */
    public NotEnoughMoney(String msg) {
        super(msg);
    }
}

