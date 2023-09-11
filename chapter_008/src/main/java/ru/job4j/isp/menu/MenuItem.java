package ru.job4j.isp.menu;
import java.util.ArrayList;
import java.util.List;
/**
 * MenuItem.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class MenuItem {
    /**
     * Field - stores value of Node.
     */
    private String name;
    /**
     * Field - stores list bound Nodes.
     */
    private List<MenuItem> children = new ArrayList<>();
    /**
     * Constructor for activation field.
     */

    public MenuItem(String name) {
        this.name = name;
    }
    /**
     * Method returns value of Node.
     */

    public String getName() {
        return name;
    }
    /**
     * Method adds to list new Nodes.
     * @param item object of MenuItem.
     */

    public void add(MenuItem item) {
        this.children.add(item);
    }
    /**
     * Method returns list of bound Nodes.
     */

    public List<MenuItem> leaves() {
        return this.children;
    }

}
