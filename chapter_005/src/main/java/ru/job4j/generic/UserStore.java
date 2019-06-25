package ru.job4j.generic;
/**
 * UserStore.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class UserStore extends AbstractStore<User> {
    /**
     * Конструктор для активации поля родителя.
     * @param size размер массива.
     */
    public UserStore(int size) {
        super(size);
    }
}


