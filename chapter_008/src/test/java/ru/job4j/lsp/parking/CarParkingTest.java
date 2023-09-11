package ru.job4j.lsp.parking;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * CarParkingTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CarParkingTest {
    @Test
    public void whenCarTakesOnePlace() {
        Vehicle passat = new Car(1);
        Map<Place, Vehicle> park = new LinkedHashMap<>();
        park.put(new Place("1", 1, false),  null);
        park.put(new Place("2", 1, false), null);
        Parking carParking = new CarParking(park);
        carParking.add(passat);
        List<Place> keys = new ArrayList<>(carParking.getMapParking().keySet());
        assertThat(carParking.getMapParking().get(keys.get(0)), is(passat));
        assertThat(keys.get(0).getOccupied(), is(true));
        assertThat(keys.get(1).getOccupied(), is(false));

    }

    @Test
    public void whenLorryTakesOnePlace() {
        Vehicle crafter = new Truck(2);
        Map<Place, Vehicle> park = new LinkedHashMap<>();
        park.put(new Place("1", 1, false), null);
        park.put(new Place("2", 2, false), null);
        Parking carParking = new CarParking(park);
        carParking.add(crafter);
        List<Place> keys = new ArrayList<>(carParking.getMapParking().keySet());
        assertThat(carParking.getMapParking().get(keys.get(1)), is(crafter));
        assertThat(keys.get(0).getOccupied(), is(false));
        assertThat(keys.get(1).getOccupied(), is(true));

    }

    @Test
    public void whenLorryTakesTwoPlace() {
        Vehicle crafter = new Truck(2);
        Map<Place, Vehicle> park = new LinkedHashMap<>();
        park.put(new Place("1", 1, false), null);
        park.put(new Place("2", 1, false), null);
        Parking carParking = new CarParking(park);
        carParking.add(crafter);
        List<Place> keys = new ArrayList<>(carParking.getMapParking().keySet());
        assertThat(carParking.getMapParking().get(keys.get(0)), is(crafter));
        assertThat(carParking.getMapParking().get(keys.get(1)), is(crafter));
        assertThat(keys.get(0).getOccupied(), is(true));
        assertThat(keys.get(1).getOccupied(), is(true));
    }
}
