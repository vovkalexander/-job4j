package ru.job4j.lsp.parking;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.Map;
/**
 * CarParkingTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CarParkingTest {
    private Vehicle passat;
    private Vehicle golf;
    private Vehicle crafter;
    private Place place1;
    private Place place2;
    private Place place3;
    private Place place4;
    private Parking carParking;
    @Before
    public void setUp() {
        passat = new Car(1);
        golf = new Car(1);
        crafter = new Truck(2);
        place1 = new Place("1", 1, false);
        place2 = new Place("2", 1, false);
        place3 = new Place("3", 2, false);
        place4 = new Place("4", 1, false);
    }
    @Test
    public void whenEveryVehicleTakesOnePlace() {
        carParking = new CarParking(Map.of(
                place1, null,
                place2, null,
                place3, null
        ));
        carParking.add(passat);
        carParking.add(crafter);
        carParking.add(golf);
        assertThat(carParking.getMapParking().get(place1), is(passat));
        assertThat(carParking.getMapParking().get(place2), is(golf));
        assertThat(carParking.getMapParking().get(place3), is(crafter));
    }
    @Test
    public void whenLorryVehicleTakestwoPlace() {
        carParking = new CarParking(Map.of(
                place1, null,
                place2, null,
                place4, null
        ));
        carParking.add(passat);
        carParking.add(crafter);
        assertThat(carParking.getMapParking().get(place1), is(passat));
        assertThat(carParking.getMapParking().get(place2), is(crafter));
        assertThat(carParking.getMapParking().get(place4), is(crafter));
    }
}
