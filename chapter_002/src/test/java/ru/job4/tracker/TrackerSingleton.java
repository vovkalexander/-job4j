package ru.job4.tracker;
import org.hamcrest.Matcher;
import org.junit.Test;
import ru.job4j.tracker.TrackerSingleVer1;
import ru.job4j.tracker.TrackerSingleVer2;
import ru.job4j.tracker.TrackerSingleVer3;
import ru.job4j.tracker.TrackerSingleVer4;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerSingleton {
    @Test
    public void whenAddTwoSingletonsThenSingletonsHaveSameData() {
        TrackerSingleVer1 tracker1 = TrackerSingleVer1.instance;
        tracker1.setData(5);
        TrackerSingleVer1 tracker2 = TrackerSingleVer1.instance;
        tracker2.setData(10);
        assertThat(tracker1.getData(), is(10));
    }

    @Test
    public void whenCreateTwoSingletonsThenSingletonHaveSameId() {
        TrackerSingleVer2 tracker1 = TrackerSingleVer2.getInstance();
        TrackerSingleVer2 tracker2 = TrackerSingleVer2.getInstance();
        assertThat(tracker1.hashCode(), is(tracker2.hashCode()));
    }

    @Test
    public void whenCreateThreeSingletonsThenSingletonsHaveSameId() {
        TrackerSingleVer3 tracker1 = TrackerSingleVer3.getInstance();
        TrackerSingleVer3 tracker2 = TrackerSingleVer3.getInstance();
        TrackerSingleVer3 tracker3 = TrackerSingleVer3.getInstance();
        assertThat(tracker1.hashCode(), is(tracker3.hashCode()));
    }

    @Test
    public void whenBuildThreeSingletonsThenSingletonsHaveSameConstructor() {
        TrackerSingleVer4 tracker1 = TrackerSingleVer4.getInstance();
        TrackerSingleVer4 tracker2 = TrackerSingleVer4.getInstance();
        TrackerSingleVer4 tracker3 = TrackerSingleVer4.getInstance();
        assertThat(tracker3, is(1));
    }
}

