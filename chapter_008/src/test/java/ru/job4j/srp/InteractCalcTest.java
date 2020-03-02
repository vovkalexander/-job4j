package ru.job4j.srp;
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
    @Test
    public void whenUserInputsTripleAddThenIsReturnedSum()  {
        String string =  "5\n3\n4\n7\nfinish";
        Double number = 14.0;
        testForTripleCalc(string, number);
    }
    @Test
    public void whenUserInputsTripleSubstThenIsReturnedBate()  {
        String string = "6\nr\n43\n57\nfinish";
        Double number = -100.0;
        testForTripleCalc(string, number);
    }
    @Test
    public void whenUserInputsTripleMultThenIsReturnedRise()  {
        String string  = "7\n12\n12\n2\nfinish";
        Double number = 288.0;
        testForTripleCalc(string, number);
    }
    @Test
    public void whenUserInputsSinThenIsReturnedTrigonometryValue()  {
        String string = "8\n45\nfinish";
        Double number = 0.8509035245341184;
        testForEngineerCalc(string, number);
    }
    @Test
    public void whenUserInputsCosThenIsReturnedTrigonometryValue()  {
        String string = "9\n3\nfinish";
        Double number = -0.9899924966004454;
        testForEngineerCalc(string, number);
    }
    @Test
    public void whenUserInputsTanThenIsReturnedTrigonometryValue()  {
        String string = "10\n15\nfinish";
        Double number = -0.8559934009085187;
        testForEngineerCalc(string, number);
    }
    @Test
    public void whenUserInputsCtgThenIsReturnedTrigonometryValue()  {
        String string = "11\n7\nfinish";
        Double number = 1.1475154224051356;
        testForEngineerCalc(string, number);
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
    /**
     * Method  activates main code of test.
     * @param str - strings of choice user.
     * @param  number- expected result.
     */
    public void testForTripleCalc(String str, Double number) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(inputStream);
        TripleInteractCalc inter =  new TripleInteractCalc(new ConsoleInput(inputStream), new ExtendedCalc(), System.out::println);
        inter.init();
        inter.getResult();
        assertThat(inter.getResult(), is(number));
    }
    /**
     * Method  activates main code of test.
     * @param str - strings of choice user.
     * @param  number- expected result.
     */
    public void testForEngineerCalc(String str, Double number) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(inputStream);
        EngineerCalc enCalc= new EngineerCalc((new ConsoleInput(System.in)), new ExtendedCalc(), System.out::println );
        enCalc.init();
        enCalc.getResult();
        assertThat(enCalc.getResult(), is(number));
    }
}