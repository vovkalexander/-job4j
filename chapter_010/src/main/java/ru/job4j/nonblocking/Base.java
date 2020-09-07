package ru.job4j.nonblocking;
/**
 * Base.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Base {
    /**
     * Field - stores link of integer.
     */
    private  int id;
    /**
     * Field - stores link of integer.
     */
    private   int version;
    /**
     * Constructor for activation fields.
     */

    public Base(int id, int version) {
        this.id = id;
        this.version = version;
    }
    /**
     * The method changes id's values.
     */

    public void setId(int id) {
        this.id = id;
    }
    /**
     * The method changes version's values.
     */

    public void setVersion(int version) {
        this.version = version;
    }
    /**
     * The method returns id's values.
     * @return integer
     */

    public int getId() {
        return id;
    }
    /**
     * The method returns version's values.
     * @return integer
     */

    public int getVersion() {
        return version;
    }
}
