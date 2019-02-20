package ru.job4.tracker.shapes;
import org.junit.Test;
import ru.job4j.shapes.Square;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * SquareTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(square.draw(),  is(new StringBuilder()
                                        .append("*****\n")
                                        .append("*   *\n")
                                        .append("*****")
                                        .toString()));
    }
}
