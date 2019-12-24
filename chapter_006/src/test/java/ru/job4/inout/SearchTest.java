package ru.job4.InOut;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * SearchTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SearchTest {
    File files = new File(System.getProperty("java.io.tmpdir"));
    @Before
    public void setUp() {
        files.mkdirs();
    }
    @Test
    public void whenAskSingleExtThenGetArrayOfExtFiles() {
        List<String> ext = new ArrayList<>();
       ext.add("tmp");
       Search search = new Search();
       assertThat(search.files(files.getAbsolutePath(), ext).size(), is (18));
    }
    @Test
    public void whenAskSomeExtThenGetArrayOfExtFiles() {
        List<String> ext = new ArrayList<>();
        ext.add("txt");
        ext.add("log");
        Search search = new Search();
        assertThat(search.files(files.getAbsolutePath(), ext).size(), is (22));
    }
}

