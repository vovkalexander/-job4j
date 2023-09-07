package ru.job4j.emailNotification;
/**
 * User.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class User {
    /**
     * Field - stores link of string.
     */
    String username;
    /**
     * Field - stores link of string.
     */
    String email;
    /**
     * Constructor for activation fields.
     */

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
    /**
     * The method returns field's username.
     * @return string
     */

    public String getUsername() {
        return username;
    }
    /**
     * The method returns field's email.
     * @return string
     */

    public String getEmail() {
        return email;
    }
}
