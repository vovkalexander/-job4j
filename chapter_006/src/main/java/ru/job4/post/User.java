package ru.job4.post;
import java.util.Set;
/**
 * User.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class User {
    /**
     *  Поле - список emails .
     */
    private Set<String> emailAdress;
    /**
     * Конструктор для активации полей.
     * @param emailAdress - набор emails.
     */
    public User(Set<String> emailAdress) {
        this.emailAdress = emailAdress;
    }
    /**
     * Метод возвращает набор emails .
     * @return набор emails.
     */
    public Set<String> getEmailAdress() {
        return emailAdress;
    }
}





