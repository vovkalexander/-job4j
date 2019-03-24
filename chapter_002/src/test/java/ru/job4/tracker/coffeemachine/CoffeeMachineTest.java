package ru.job4.tracker.coffeemachine;

import org.junit.Test;
import ru.job4j.cofeemashine.CoffeeMachine;
import ru.job4j.cofeemashine.NotEnoughMoney;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CoffeeMachineTest {
    @Test
    public void whenPriceThirtyFiveThenChangeFifteenCoins() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] actual = coffeeMachine.changes(50, 35);
        int[] expected = {10, 5};
        assertThat(actual, is(expected));
    }
    @Test
    public void whenPriceFourtyTwoThenChangeEightCoins() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] actual = coffeeMachine.changes(50, 42);
        int[] expected = {5, 2, 1};
        assertThat(actual, is(expected));
    }
    @Test
    public void whenPriceSeventyThreeThenChangeTwentySevenCoins() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] actual = coffeeMachine.changes(100, 73);
        int[] expected = {10, 10, 5, 2};
        assertThat(actual, is(expected));
    }
    @Test(expected = NotEnoughMoney.class)
    public void whenPriceGraterThenValueThan() throws NotEnoughMoney {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] actual = coffeeMachine.changes(100, 120);
    }
}
