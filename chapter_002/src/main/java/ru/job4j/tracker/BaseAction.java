package ru.job4j.tracker;
/**
 * BaseAction - абстрактный класс.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public abstract class  BaseAction implements UserAction {
    private final int key;
    private final String name;
    /**
     * Конструтор инициализирующий поля.
     * @param key номер пункта меню.
     * @param name название пункта меню.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }
    @Override
    public int key() {
        return this.key;
    }
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
