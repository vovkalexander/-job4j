package ru.job4j.srp;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayInputStream;
/**
 * InteractCalcTest
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class InteractCalcTest {
    @Test
    public void whenUserInputsAddThenIsReturnedSum()  {
        String string =  "0\n3\n4\nfinish";
        Double number = 7.0;
        test(string, number);
    }
    @Test
    public void whenUserInputsSubstThenIsReturnedBate()  {
        String string = "1\nr\n43\nfinish";
        Double number = -43.0;
        test(string, number);
    }
    @Test
    public void whenUserInputsMultThenIsReturnedRise()  {
        String string  = "2\n12\n12\nfinish";
        Double number = 144.0;
        test(string, number);
    }
    @Test
    public void whenUserInputsDivThenIsReturnedSplit()  {
        String string = "3\n1024\n8\nfinish";
        Double number = 128.0;
        test(string, number);
    }
    /**
     * Method  activates main code of test.
     * @param str - strings of choice user.
     * @param  number- expected result.
     */
    public void test(String str, Double number) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(inputStream);
        InteractCalc inter =  new InteractCalc(new ConsoleInput(inputStream), new ExtendedCalc(), System.out::println);
        inter.init();
        inter.getResult();
        assertThat(inter.getResult(), is(number));
    }
}