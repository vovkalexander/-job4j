package ru.job4j.generic;
/**
 * Base.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public abstract class Base {
    /**
     * Поле - хранит id объекта.
     */
    private final String id;
    /**
     * Конструктор для активации поля.
     * @param id объекта.
     */

    protected Base(final String id) {
        this.id = id;
    }
    /**
     * Метод - возвращает id объекта.
     */

    public String getId() {
        return id;
    }
}
