package ru.job4j.search;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Alexander", "Vovk", "115142", "Moscow"));
        var persons = phones.find("Ale");
        assertThat(persons.iterator().next().getSurname(), is("Vovk"));
    }

    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Alexander", "Vovk", "115142", "Moscow"));
        var persons = phones.find("115");
        assertThat(persons.iterator().next().getAddress(), is("Moscow"));
    }
}
