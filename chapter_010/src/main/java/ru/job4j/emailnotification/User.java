package ru.job4j.emailnotification;
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
   private String username;
    /**
     * Field - stores link of string.
     */
   private String email;
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
