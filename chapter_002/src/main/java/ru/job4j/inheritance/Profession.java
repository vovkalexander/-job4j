package ru.job4j.inheritance;
/**
 * Profession.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class Profession {
    /**
     * @param name of profession .
     */
    public String name;
    /**
     * @param name of worker .
     */
    public String profession;
    /**
     * constructor profession empty.
     */
    public Profession() {
    }
    /**
     * constructor profession for initializing.
     * @param name for initializing.
     * @param profession for initializing.
     */
    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    /**
     * method  getName.
     * @return  initialized name .
     */

    public String getName(String name) {
        return name;
    }
    /**
     * method getProfession.
     * @return  initialized profession.
     */
    public String getProfession(String profession) {
        return profession;
    }
}
