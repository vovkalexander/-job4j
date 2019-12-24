package ru.job4j.function;
import org.junit.Test;
import ru.job4j.functions.Functions;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FunctionsTest {
    Functions function = new Functions();
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> x + 5);
        List<Double> expected = Arrays.asList(10D, 11D, 12D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSquaredFunctionThenSquaredResults() {
        List<Double> result = function.diapason(2, 5, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(4D, 9D, 16D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        List<Double> result = function.diapason(7, 10, x -> Math.log(x));
        List<Double> expected = Arrays.asList(Math.log(7), Math.log(8), Math.log(9));
        assertThat(result, is(expected));
    }
}
