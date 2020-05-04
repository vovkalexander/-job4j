package ru.job4j.tdd.pattern;
import java.util.Map;
/**
 * Generator
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Generator {
    /*
     * The method returns  converted template by Map's values.
     * @param template - string for making into.
     * @param args - map with values for replacing.
     * @return string - result.
     */
    String produce(String template, Map<String, String> args);
}
