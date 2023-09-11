package ru.job4j.isp;
import org.junit.Test;
import ru.job4j.isp.menu.BaseAction;
import ru.job4j.isp.menu.Menu;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * BaseActionTest
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BaseActionTest {
    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenAddsItemToMenuThenRecieveOrderedMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("exit".getBytes());
        System.setIn(inputStream);
        Menu menu = new Menu("Menu");
        menu.add("Menu", "Task 1");
        menu.add("Task 1", "Task 1.1");
        menu.add("Task 1", "Task 1.1.1");
        menu.add("Task 1", "Task 1.1.2");
        menu.add("Task 1", "Task 1.2");
        System.setOut(new PrintStream(out));
        BaseAction conversation = new BaseAction(System.in, menu);
        conversation.init();
        StringBuilder expect = new StringBuilder();
        expect.append("Choose item of menu or put " + (char) 34 + "exit" + (char) 34 + " for disconnecting").append(LN).
                append("Menu").append(LN).
                append("Task 1").append(LN).
                append("Task 1.1").append(LN).
                append("Task 1.1.1").append(LN).
                append("Task 1.1.2").append(LN).
                append("Task 1.2").append(LN);
        assertThat(out.toString(), is(expect.toString()));
    }
}
