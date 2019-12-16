package ru.job4.critery;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
/**
 * Predicate.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public interface Predicate {
    /**
     * Метод абстрактный execute.
     */
 List<Path> execute(Arg arg) throws IOException;
}
