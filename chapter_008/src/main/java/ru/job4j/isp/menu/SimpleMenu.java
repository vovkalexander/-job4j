package ru.job4j.isp.menu;
import java.util.Optional;
/**
 * Interface SimpleMenu.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public interface SimpleMenu extends Display {
    /**
     * Method  adds item of menu to tree.
     * @param parent - rooted item.
     * @param child - leaves of tree.
     * @return 	logical conclusion.
     */
    boolean add(String parent,  String child);
    /**
     * Method  finds item by value of item into tree.
     * @param value -  item's value.
     * @return 	filled up collection.
     */
    Optional<MenuItem> findBy(String value);
}
