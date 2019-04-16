package ru.job4j.cofeemashine;

public class NotEnoughMoney extends RuntimeException {
    /**
     * Конструктор - наследует конструктор родителя.
     * @param msg - сообщение на консоль о наличие исключения.
     */
    public NotEnoughMoney(String msg) {
        super(msg);
    }
}
