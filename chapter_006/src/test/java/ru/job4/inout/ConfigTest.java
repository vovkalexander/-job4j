package ru.job4.InOut;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * ConfigTest
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ConfigTest {
    Config config;
    @Before
    public void SetUp() {
        config = new Config("C:\\projects\\student\\Vovk Alexander\\-job4j\\app.properties");
    }
    @Test
    public void whenFileIsReadThenArrayHasSize() {
        config.load();
        assertThat(config.getMap().size(), is(5));
    }
    @Test
    public void whenFileIsReadThenArrayCanGetValueByKey() throws ValueNotFoundException {
        config.load();
        assertThat(config.value("hibernate.connection.username"), is ("postgres"));
        assertThat(config.value("hibernate.connection.password"), is ("password"));
    }

    @Test(expected = ValueNotFoundException.class)
    public void whenKeyOfArrayNotEqualsValueThenException() throws ValueNotFoundException {
        Config config = new Config("C:\\projects\\student\\Vovk Alexander\\-job4j\\app.properties");
        config.load();
        assertThat(config.value("password"), is ("password"));
    }
}