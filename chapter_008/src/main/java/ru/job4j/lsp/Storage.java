package ru.job4j.lsp;
import java.text.ParseException;
/**
 * Storage - interface
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public interface Storage extends Reinterment {
    boolean addFood(Food food) throws ParseException;
}
