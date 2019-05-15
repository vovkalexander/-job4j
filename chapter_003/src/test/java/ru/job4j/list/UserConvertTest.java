package ru.job4j.list;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
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
        List<User> list = List.of(
        new User(3, "Hoolio", "de Pantalones"),
        new User(8, "Jkаkashi", "Nagano"),
        new User(2, "Kuzmitch", "Herson"));
        HashMap<Integer, User> result = convert.process(list);
        assertThat(result.get(8).getName(), is("Jkаkashi"));
    }
}
