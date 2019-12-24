package ru.job4.inout;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.io.File;
import java.util.List;
/**
 * ZipTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ZipTest {
 @Test
 public void archiveInZipTest() {
    String[] args = {"-d", System.getProperty("user.dir"), "-e", ".java", "-o", "..\\test.zip"};
      Zip zip = new Zip(args);
      List<File> list = zip.seekBy(zip.arg.directory(), zip.arg.exclude());
     zip.pack(list, new File(zip.arg.output()));
     File file = new File("..\\test.zip");
       assertThat(list.size(), is(40));
       assertThat(file.length(), is(17102L));
  }
}