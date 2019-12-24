package ru.job4.inout;
import org.junit.Test;
import java.io.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * AnalizyTest
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AnalizyTest {
  @Test
  public void when() throws IOException {
     File file = new File("unavailable.csv");
      Analizy analizy = new Analizy();
       analizy.unavailable("\\C:\\projects\\student\\Vovk Alexander\\-job4j\\server", "unavailable.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));
       assertThat(reader.readLine(), is("10:57:01;10:59:01"));
      assertThat(reader.readLine(), is("11:01:02;11:02:02"));
  }
}