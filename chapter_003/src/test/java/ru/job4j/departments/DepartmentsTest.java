package ru.job4j.departments;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1\\sk1","k1\\sk2",
                "k1\\sk1\\ssk1",
                "k1\\sk1\\ssk2",
                "k2",
                "k2\\sk1\\ssk1",
                "k2\\sk1\\ssk2");
        Departments deps = new Departments(input);
        Set<String> expect = Stream.of("k1","k1\\sk1",
                "k1\\sk1\\ssk1",
                "k1\\sk1\\ssk2",
                "k1\\sk2",
                "k2",
                "k2\\sk1",
                "k2\\sk1\\ssk1",
                "k2\\sk1\\ssk2" ).collect(Collectors.toSet());
        Set<String> result = deps.convert(input);
        assertThat(result, is(expect));
    }
    @Test
    public void whenAsc() {
        List<String> input = Arrays.asList("k2","k1\\sk1","k2");
        Departments deps = new Departments(input);
        List<String> expect = Arrays.asList("k1","k1\\sk1","k2");
        List<String> result = deps.sortAsc(input);
        assertThat(result, is(expect));
    }
    @Test
    public void whenDesc() {
        List<String> input = Arrays.asList("k3","k1\\sk1","k3","k2\\sk2");
        Departments deps = new Departments(input);
        List<String> expect = Arrays.asList("k3","k2","k2\\sk2","k1","k1\\sk1");
    }
}
