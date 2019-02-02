package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Vovk Alexander  (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = new String[] {"Ашот", "Афоня", "Мухтар", "Афоня", "Мухтар", "Афоня", "Ашот"};
        String[] result = arrayDuplicate.remove(array);
        assertThat(result, is(new String[] {"Ашот", "Афоня", "Мухтар"}));
    }
}


