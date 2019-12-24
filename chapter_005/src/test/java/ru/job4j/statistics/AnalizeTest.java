package ru.job4j.statistics;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.statistics.Analize.User;
/**
 * AnalizeTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class AnalizeTest {
    List<User> previous;
    @Before
    public void setUp() {
        previous = new ArrayList<>();
        previous.add(new User(23, "Jordan"));
        previous.add(new User(33, "Pippen"));
    }
    @Test
    public void whenArraysEqualThenStatisticNotChanging() {
        List<User> current = new ArrayList<>();
        current.add(new User(23, "Jordan"));
        current.add(new User(33, "Pippen"));
        Analize.Info info = new Analize().diff(previous, current);
        Analize.Info expect = new Analize.Info(0, 0, 0);
        assertThat(expect, is(info));
    }
    @Test
    public void whenCurrentAddElementThenStatisticAddPosition() {
        List<User> current = new ArrayList<>();
        current.add(new User(23, "Jordan"));
        current.add(new User(33, "Pippen"));
        current.add(new User(15, "Carter"));
        Analize.Info info = new Analize().diff(previous, current);
        Analize.Info expect = new Analize.Info(1, 0, 0);
        assertThat(expect, is(info));
    }
    @Test
    public void whenCurrentIsChangingThenStatisticChangePosition() {
        List<User> current = new ArrayList<>();
        current.add(new User(23, "James"));
        current.add(new User(33, "Pippen"));
        Analize.Info info = new Analize().diff(previous, current);
        Analize.Info expect = new Analize.Info(0, 1, 0);
        assertThat(expect, is(info));
    }
    @Test
    public void whenCurrentHasLessElementsThenStatisticIncreasesDeletePosition() {
        List<User> current = new ArrayList<>();
        current.add(new User(23, "Jordan"));
        Analize.Info info = new Analize().diff(previous, current);
        Analize.Info expect = new Analize.Info(0, 0, 1);
        assertThat(expect, is(info));
    }
}