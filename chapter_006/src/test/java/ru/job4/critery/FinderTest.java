package ru.job4.critery;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * AnalizyTest
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FinderTest {
    private String[] args = {"-d", System.getProperty("user.dir"), "-n", "null", "-m", ".xml",
            "-f", "pom", "-r", "j.+a", "-o", "..\\result.txt"};

    @Test
    public void whenChoiceOfFullNameThenSearchByFullName()  throws IOException {
        String str = "-f";
        int size = 1;
        test(str,size);
    }
    @Test
    public void whenChoiceOfRegExpThenSearchByRegExp()  throws IOException {
        String str = "-r";
        int size = 51;
        test(str, size);
    }
    @Test
    public void whenChoiceOfMaskThenSearchByMask()  throws IOException {
        String str = "-m";
        int size = 3;
        test(str, size);
    }
    /**
     * Метод - инициализации основного кода теста.
     * @param str - строка выбора критерия пользователя .
     * @param  number- число размера списка.
     */
    public void test(String str, int number) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        Finder finder = new Finder(args);
        finder.search();
        List<String> expect = new ArrayList<>();
        String string;
        try (BufferedReader read = new BufferedReader(new FileReader(new Arg(args).getMap().get("output")))) {
            while ((string = read.readLine()) != null) {
                expect.add(string);
            }
            assertThat(finder.getMfv().getList().size(), is(number));
            assertThat(finder.getMfv().getList().retainAll(expect), is(false));
        }
    }
}