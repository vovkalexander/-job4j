package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test
 * @author Vovk Alexander  (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound5Then1491625() {
        int bound = 5;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16, 25};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound6Then149162536() {
        int bound = 6;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16, 25, 36};
        assertThat(rst, is(expect));
    }
}
