package ru.job4j.departments;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
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
    public void whenAsc() {
        List<String> input = Arrays.asList("k1\\sk1", "k1\\sk2",
                "k1\\sk1\\ssk1",
                "k1\\sk1\\ssk2",
                "k2",
                "k2\\sk1\\ssk1",
                "k2\\sk1\\ssk2");
        Departments deps = new Departments(input);
        List<String> expect = Arrays.asList("k1", "k1\\sk1",
                "k1\\sk1\\ssk1",
                "k1\\sk1\\ssk2",
                "k1\\sk2",
                "k2",
                "k2\\sk1",
                "k2\\sk1\\ssk1",
                "k2\\sk1\\ssk2");
        List<String> result = deps.sortAsc(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenDesc() {
        List<String> input = Arrays.asList("k1\\sk1", "k1\\sk2",
                "k1\\sk1\\ssk1",
                "k1\\sk1\\ssk2",
                "k2",
                "k2\\sk1\\ssk1",
                "k2\\sk1\\ssk2");
        Departments deps = new Departments(input);
        List<String> expect = Arrays.asList("k2", "k2\\sk1", "k2\\sk1\\ssk2",
                "k2\\sk1\\ssk1",
                "k1",
                "k1\\sk2",
                "k1\\sk1",
                "k1\\sk1\\ssk2",
                "k1\\sk1\\ssk1");
        List<String> result = deps.sortDesc(input);
        assertThat(result, is(expect));
    }
}
