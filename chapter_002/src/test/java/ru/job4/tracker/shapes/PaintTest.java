package ru.job4.tracker.shapes;
import java.util.StringJoiner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.shapes.Paint;
import ru.job4j.shapes.Square;
import ru.job4j.shapes.Triangle;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * PaintTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append("*****\n")
                                .append("*   *\n")
                                .append("*****")
                                .append(System.lineSeparator())
                                .toString()));
    }
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append("   *   \n")
                                .append("  ***  \n")
                                .append(" ***** \n")
                                .append("*******")
                                .append(System.lineSeparator())
                                .toString()));
    }
}

