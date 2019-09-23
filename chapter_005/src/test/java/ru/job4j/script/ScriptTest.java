package ru.job4j.script;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * ScriptTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ScriptTest {
    @Test
    public void whenLoadScriptThenGetInterconnectedListOfScript() {
        Map<Integer, List<Integer>> map = Map.of(1, List.of(2,3), 2, List.of(4), 3, List.of(4,5),
                4, List.of(), 5, List.of());
        Script script = new Script();
        List<Integer> list = script.load(map, 1);
        assertThat(list.size(), is(5));
        assertThat(list, is(List.of(1,2,3,4,5)));
    }
}