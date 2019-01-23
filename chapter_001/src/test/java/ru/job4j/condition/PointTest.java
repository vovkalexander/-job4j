package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PointTest {
    /**
     *  Test distanceTo.
     */

    @Test
    public void whenCoordinatesSetTwoPointsThenDistanceBetweenPoints() {
        Point a = new Point(0, 1);
        Point b = new Point(3, 6);
        double result = a.distanceTo(b);
        double expected = 6D;
        assertThat(result, closeTo(expected, 0.2));
    }



}
