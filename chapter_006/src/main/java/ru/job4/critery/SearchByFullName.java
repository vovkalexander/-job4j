package ru.job4.critery;
import java.nio.file.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * SearchByFullName.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SearchByFullName implements Predicate {
    @Override
    public List<Path> execute(Arg arg) throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(arg.getMap().get("direct")))) {
            return   paths.filter(
                    file -> file.getFileName().toString().contains(arg.getMap().get("fullname"))).
                    collect(Collectors.toList());
        }
    }
}