package ru.job4j.srp;
import org.junit.Before;
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
    /**
     * Field - store link for object of Calculator.
     */
    private Calculator calculator;
    ActionFactory factory;
    @Before
    public void initObjects() {
        calculator = new Calculator();
        factory = new ActionFactory();
    }
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
    /**
     * Method  activates main code of test.
     * @param str - strings of choice user.
     * @param  number- expected result.
     */
    public void test(String str, Double number) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(inputStream);
        InteractCalc inter = new InteractCalc(calculator, inputStream, factory);
        inter.chooseCategory();
        assertThat(inter.getResult(), is(number));
    }
}