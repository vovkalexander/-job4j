package ru.job4j.tdd.pattern;
import java.util.Map;
/**
 * SimpleGenerator
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleGenerator implements Generator {
    @Override
    public String produce(String template, Map<String, String> args) {
        return "I am Petr, Who are you?";
    }
}