package ru.job4.InOut;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
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
    @Test
    public void whenAskDifferentExtThenGetArrayOfExtFiles() throws IOException {
        String way = System.getProperty("java.io.tmpdir") + File.separator + "test_search";
        File test = new File(way);
        test.mkdirs();
        File file1 = new File(test, "a.pdf");
        file1.createNewFile();
        File file2 = new File(test, "b.pdf");
        file2.createNewFile();
        File folder = new File(test, "folder_search");
        folder.mkdir();
        File file3 = new File(folder, "c.pdf");
        file3.createNewFile();
        File file4 = new File(folder, "d.text");
        file4.createNewFile();
        List<String> ext1 = new ArrayList<>();
        ext1.add("pdf");
        List<String> ext2 = new ArrayList<>();
        ext2.add("pdf");
        ext2.add("text");
        Search search = new Search();
        assertThat(search.files(test.getAbsolutePath(), ext1).size(), is(3));
        assertThat(search.files(test.getAbsolutePath(), ext2).size(), is(4));
    }
}

