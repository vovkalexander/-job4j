package ru.job4.critery;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
/**
 * SearchByRegEx.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SearchByRegEx implements Predicate {
    @Override
    public List<Path> execute(Arg arg) throws IOException {
        List<Path> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(arg.getMap().get("name"));
        try(Stream<Path> paths = Files.walk(Paths.get(arg.getMap().get("direct")))) {
            paths.filter(path -> pattern.matcher(path.getFileName().toString()).find())
                    .forEach(list::add);
        }
        return list;
    }
}
