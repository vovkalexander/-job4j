package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MaxTest {

    @Test
    public void whenThirdMoreFirstAndSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2,5);
        assertThat(result, is(5));
    }

}
