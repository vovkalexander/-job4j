package ru.job4.tracker.shapes;
import org.junit.Test;
import ru.job4j.shapes.Triangle;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * TriangleTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder()
                                      .append("   *   \n")
                                      .append("  ***  \n")
                                      .append(" ***** \n")
                                      .append("*******")
                                      .toString()));
    }
}
