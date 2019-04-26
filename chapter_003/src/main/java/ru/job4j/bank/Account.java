package ru.job4j.bank;
/**
 * Account.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Account  {
    /**
     * Поле - хранит сумму пользователя.
     */
    private double values;
    /**
     * Поле - хранит реквизиты пользователя.
     */
    private String requisites;
    /**
     * Конструктор для активации полей.
     * @param values сумма пользователя.
     * @param requisites реквизиты пользователя.
     */
    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }
    /**
     * Метод возвращает сумму пользователя.
     * @return сумма пользователя.
     */
    public double getValues() {
        return this.values;
    }
    /**
     * Метод возвращает реквизиты пользователя.
     * @return реквизиты пользователя.
     */
    public String getReqs() {
        return this.requisites;
    }
    /**
     * Метод переводит сумму на счет пользователя.
     * @param destination счет конечного пользователя.
     * @param amount сумма для перевода.
     * @return логический вывод.
     */
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }
}
