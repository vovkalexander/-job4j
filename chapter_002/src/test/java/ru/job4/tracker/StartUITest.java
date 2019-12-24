package ru.job4.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
    private final Tracker tracker = new Tracker();
    private final Item item = tracker.add(new Item("test name", "desc"));
    private  final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
        @Override
        public String toString() {
            return new String(out.toByteArray());
        }
    };
    String menu = new StringBuilder()
            .append("0. Add the new item.")
            .append(System.lineSeparator())
            .append("1. Show all items")
            .append(System.lineSeparator())
            .append("2. Edit item")
            .append(System.lineSeparator())
            .append("3. Delete item")
            .append(System.lineSeparator())
            .append("4. Find item by Id")
            .append(System.lineSeparator())
            .append("5. Find items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program")
            .append(System.lineSeparator())


            .toString();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(System.out);
    }
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(Arrays.asList("0", "test name", "desc", "6"));   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(Arrays.asList("2", item.getId(), "test replace", "заменили заявку", "6"));
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        //создаём StubInput с последовательностью действий(удаляем заявку)
        Input input = new StubInput(Arrays.asList("3", item.getId(), "6"));
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, System.out::println).init();
        //// проверяем, что нулевой элемент массива в трекере удален, введённое при эмуляции.
        assertThat(this.output.toString(), is(new StringBuilder()
                .append(menu)
                .append("---------Removing  -------")
                .append(System.lineSeparator())
                .append("Item removed")
                .append(System.lineSeparator())
                .append(menu)
                .toString()));
    }
    @Test
    public void whenFindByIdThenTrackerHasFoundByIdValue() {
        //создаём StubInput с последовательностью действий(находим заявку по id)
        Input input = new StubInput(Arrays.asList("4", item.getId(), "6"));
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, System.out::println).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(this.output.toString(), is(new StringBuilder()
                .append(menu)
                .append("---------Finding item by ID -------")
                .append(System.lineSeparator())
                .append("Item's name :" + item.getName())
                .append(System.lineSeparator())
                .append(menu)
                .toString()));
    }
    @Test
    public void whenFindByNameThenTrackerHasFoundByNameValue() {
        //создаём StubInput с последовательностью действий(находим заявку по имени)
        Input input = new StubInput(Arrays.asList("5", item.getName(), "6"));
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, System.out::println).init();
        //// // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(this.output.toString(), is(new StringBuilder()
                .append(menu)
                .append("---------Finding item by Name -------")
                .append(System.lineSeparator())
                .append("Item's name :" + item.getName() + " " + "ID :" + item.getId())
                .append(System.lineSeparator())
                .append(menu)
                .toString()));
    }
    @Test
    public void whenShowAllItemsThenTrackerHasShowedAllItemsValue() {
        //Напрямую добавляем первую заявку
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        //Напрямую добавляем вторую заявку
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        //создаём StubInput с последовательностью действий(находим все заявки)
        Input input = new StubInput(Arrays.asList("1", "6"));
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, System.out::println).init();
        //// // проверяем, что заявки находяться в массиве, введённое при эмуляции.
        assertThat(this.output.toString(), is(new StringBuilder()
                .append(menu)
                .append("------------ All Items --------------")
                .append(System.lineSeparator())
                .append("Item with name:" + item.getName() + " " + "ID :" + item.getId())
                .append(System.lineSeparator())
                .append("Item with name:" + item1.getName() + " " + "ID :" + item1.getId())
                .append(System.lineSeparator())
                .append("Item with name:" + item2.getName() + " " + "ID :" + item2.getId())
                .append(System.lineSeparator())
                .append(menu)
                .toString()));
    }
}




