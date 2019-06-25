package ru.job4j.generic;
/**
 * RoleStore.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class RoleStore extends AbstractStore<Role> {
    /**
     * Конструктор для активации поля родителя.
     * @param size размер массива.
     */
    public RoleStore(int size) {
        super(size);
    }
}
