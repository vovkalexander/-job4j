package ru.job4j.Cache;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * CacheTest
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CacheTest {
    @Test
    public void getDataOfNameFromCache() throws IOException {
        Path path = Paths.get("name.txt");
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        String text = new StringBuilder()
                .append("Percy")
                .append(System.lineSeparator())
                .append("Peter")
                .append(System.lineSeparator())
                .append("Patrick")
                .append(System.lineSeparator())
                .toString();
        Files.write(path, text.getBytes());
        SimpleCache cache = new SimpleCache(System.getProperty("user.dir"));
        assertThat(cache.getCache().size(), is(0));
        assertThat(cache.getStuff("name.txt"), is(text));
    }

    @Test
    public void getDataOfAddressFromCache() throws IOException {
        Path path = Paths.get("address.txt");
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        String text = new StringBuilder()
                .append("house of straw")
                .append(System.lineSeparator())
                .append("house of wood")
                .append(System.lineSeparator())
                .append("house of bricks")
                .append(System.lineSeparator())
                .toString();
        Files.write(path, text.getBytes());
        SimpleCache cache = new SimpleCache(System.getProperty("user.dir"));
        assertThat(cache.getStuff("address.txt"), is(text));
    }
}