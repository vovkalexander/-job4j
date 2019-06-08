package ru.job4j.streamApi;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StreamApiTest {
    @Test
    public void whenListConvertIntoOneElement() {
        List<Integer> lists = Arrays.asList(3,4,5,7,8,10,11);
        StreamApi api = new StreamApi();
        Optional<Integer> result = api.stream(lists);
        assertThat(result.get(), is(180));
    }
}
