package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Test
 * @author Vovk Alexander  (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[]{2, 6, 1, 4};
        assertThat(result, is(expect));
    }
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{7, 3, 5, 2, 4};
        int[] result = turner.back(input);
        int[] expect = new int[]{4, 2, 5, 3, 7};
        assertThat(result, is(expect));
    }
}
