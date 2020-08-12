package ru.job4j.concurrent;
/**
 * User.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class User {
    /**
     * Field - stores link of integer.
     */
    private int id;
    /**
     * Field - stores link of String's object.
     */
    private String name;
    /**
     * static block for using static initialization class.
     */

    public static User of(String name) {
        User user = new User();
        user.name = name;
        return user;
    }
    /**
     * The method returns id's values.
     * @return integer
     */

    public int getId() {
        return id;
    }
    /**
     * The method changes id's values.
     */

    public void setId(int id) {
        this.id = id;
    }
    /**
     * The method returns name of user's object.
     * @return name.
     */

    public String getName() {
        return name;
    }

    /**
     * The method changes name of user's object.
     */

    public void setName(String name) {
        this.name = name;
    }
}

