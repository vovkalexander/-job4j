package ru.job4.inout;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * ConsoleChatTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleChatTest {
  private String str = System.getProperty("user.dir") + File.separator + "result";

    @Test
    public void whenFinishAtOnceThenEmptyArray() throws IOException {
      ConsoleChat chat = new ConsoleChat("закончить");
       chat.setUp();
       assertThat(chat.getList().size(), is(2));
   }

   @Test
   public void whenChatHasTalkThenFieldOfChatEqualsFile() throws IOException {
      ConsoleChat chat = new ConsoleChat("Привет" + "\n" + "какдела" + "\n" + "что?" + "\n" + "стоп" + "\n" + "помолчим" + "\n" + "уговорил" + "\n" + "продолжить" + "\n" + "закончить");
      chat.setUp();
      chat.writeDown(chat.getList(), str);
       List<String> expect = new ArrayList<>();
       String string;
       try (BufferedReader read = new BufferedReader(new FileReader(str))) {
            while ((string = read.readLine()) != null) {
                expect.add(string);
           }
        }
        assertThat(chat.getList().size(), is(8));
        assertThat(chat.getList().size(), is(expect.size()));
    }
}