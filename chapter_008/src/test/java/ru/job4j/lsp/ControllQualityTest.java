package ru.job4j.lsp;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
/**
 * ControllQualityTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ControllQualityTest {
    private Food milk;
    private Food meat1;
    private Food meat2;
    private Food meat3;
    private ControllQuality contQual;
    private Warehouse ware = new Warehouse();
    private Trash trash = new Trash();
    private Shop shop = new Shop();
    @Before
    public void setUp() throws ParseException {
        milk = new Food("milk","10 05 2020", "16 04 2020", 75.0, 0.2);
        meat1 = new Food("chicken","18 04 2020", "25 03 2020", 228.0,0.3);
        meat2 = new Food("turkey","22 04 2020", "04 04 2020", 310.0, 0.3);
        contQual = new ControllQuality();
        ware = new Warehouse();
        trash = new Trash();
        shop = new Shop();
    }
    @Test
    public void distributingFoodsTest() throws ParseException {
        contQual.addStorage(trash);
        contQual.addStorage(shop);
        contQual.addStorage(ware);
        contQual.checkStorage(milk);
        contQual.checkStorage(meat1);
        contQual.checkStorage(meat2);
        contQual.resort();
        assertThat(ware.getList().get(0).getName(), is("milk") );
        assertThat(shop.getList().get(0).getName(), is("turkey"));
        assertThat(trash.getList().get(0).getName(), is("chicken"));
        assertThat(meat2.getPrice(), is(151.9));
    }
}
