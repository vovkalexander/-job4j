package ru.job4j.list;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserConvertTest {
    @Test
    public void whenConvert3elementsOfListThen3ElementsOfHashMap() {
        UserConvert convert = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(3, "Hoolio", "de Pantalones"));
        list.add(new User(8, "Jkаkashi", "Nagano"));
        list.add(new User(2, "Kuzmitch", "Herson"));
        HashMap<Integer, User> result = convert.process(list);
        assertThat(result.get(8).getName(), is("Jkаkashi"));
    }
}
