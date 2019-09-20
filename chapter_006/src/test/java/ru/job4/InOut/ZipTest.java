package ru.job4.InOut;
import org.junit.Test;
import java.io.File;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * ZipTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ZipTest {
    @Test
    public void archiveInZipTest() {
        String[] args = {"-d", "C:\\projects\\student\\Vovk Alexander\\-job4j\\chapter_005", "-e", ".java", "-o", "C:\\projects\\student\\Vovk Alexander\\-job4j.zip"};
        Zip zip = new Zip(args);
        List<File> list = zip.seekBy(zip.arg.directory(), zip.arg.exclude());
        zip.pack(list, new File(zip.arg.output()));
        File file = new File("C:\\projects\\student\\Vovk Alexander\\-job4j.zip");
        assertThat(list.size(), is(68));
        assertThat(file.length(), is(71540l));
    }
}