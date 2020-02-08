package ru.job4j.srp;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.calculator.Calculator;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
/**
 * InteractCalcTest
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class InteractCalcTest {
    @Test
    public void whenUserInputsAddThenIsReturnedSum() throws IOException {
        String string = "+ 4 4 finish";
        Double number = 8.0;
        test(string, number);
    }
    @Test
    public void whenUserInputsSubstThenIsReturnedBate() throws IOException {
        String string = "- r 74 finish";
        Double number = -74.0;
        test(string, number);
    }
    @Test
    public void whenUserInputsMultThenIsReturnedRise() throws IOException {
        String string  = "* 12 12 finish";
        Double number = 144.0;
        test(string, number);
    }
    @Test
    public void whenUserInputsDivThenIsReturnedSplit() throws IOException {
        String string = "/ 1024 8 finish";
        Double number = 128.0;
        test(string, number);
    }
    @Ignore
    public void whenUserInputsSinThenIsReturnedTrigonometryValue() throws IOException {
        String string = "sin 45 finish";
        Double number = 0.8509035245341184;
        test(string, number);
    }

    @Ignore
    public void whenUserInputsCosThenIsReturnedTrigonometryValue() throws IOException {
        String string = "cos 3 finish";
        Double number = 0.1411200080598672;
        test(string, number);
    }
    @Ignore
    public void whenUserInputsTanThenIsReturnedTrigonometryValue() throws IOException {
        String string = "tan 15 finish";
        Double number = 0.6502878401571168;
        test(string, number);
    }
    @Ignore
    public void whenUserInputsCtgThenIsReturnedTrigonometryValue() throws IOException {
        String string = "ctg 7  finish";
        Double number = 0.6569865987187891;
        test(string, number);
    }
    /**
     * Method  activates main code of test.
     * @param str - strings of choice user.
     * @param  number- expected result.
     */
    public void test(String str, Double number) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(inputStream);
        InteractCalc inter = new InteractCalc();
        inter.chooseCategory();
        assertThat(inter.getResult(), is(number));
    }
}