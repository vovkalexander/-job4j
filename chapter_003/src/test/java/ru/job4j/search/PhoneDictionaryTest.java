package ru.job4j.search;
import org.junit.Test;
import java.util.List;
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
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Alexander", "Vovk", "115142", "Moscow"));
        List<Person> persons = phones.find("Ale");
        assertThat(persons.iterator().next().getSurname(), is("Vovk"));
    }
    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Alexander", "Vovk", "115142", "Moscow"));
        List<Person> persons = phones.find("115");
        assertThat(persons.iterator().next().getAddress(), is("Moscow"));
    }
}
