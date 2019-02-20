package ru.job4.tracker.shapes;
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
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
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
        System.setOut(stdout);
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
        System.setOut(stdout);
    }
}

