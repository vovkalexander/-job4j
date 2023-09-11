package ru.job4j.tdd.pattern;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * GeneratorTest
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class GeneratorTest {
    @Test
    public void replaceKeysByValues() throws Exception {
        Generator generator = new SimpleGenerator();
        String text = "I am ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("subject", "you");
        String result = generator.produce(text, map);
        String expect = "I am Petr, Who are you";
        assertThat(result, is(expect));
    }

    @Test(expected = Exception.class)
    public void whenUnmatchedKeys() throws Exception {
        Generator generator = new SimpleGenerator();
        String text = "I am ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("noName", "NoPetr");
        map.put("pronoun", "mine");
        generator.produce(text, map);
    }

    @Test(expected = Exception.class)
    public void whenALotOfKeys() throws Exception {
        Generator generator = new SimpleGenerator();
        String text = "I am ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("subject", "you");
        map.put("noName", "NoPetr");
        generator.produce(text, map);
    }
}



































