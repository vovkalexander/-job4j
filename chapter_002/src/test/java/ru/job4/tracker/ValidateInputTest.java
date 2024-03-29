package ru.job4.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.StubInput;
import ru.job4j.tracker.ValidateInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(Arrays.asList("invalid", "1"))
        );
        input.ask("Enter", Arrays.asList((Integer) 1));
        assertThat(
                this.mem.toString(),
                is(
                        String.format("please enter validate data again.%n")
                )
        );
    }

    @Test
    public void whenExceedInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(Arrays.asList("5", "1"))
        );
        input.ask("10", Arrays.asList((Integer) 1));
        assertThat(
                this.mem.toString(),
                is(
                        String.format("please select key from menu.%n")
                )
        );
    }
}

