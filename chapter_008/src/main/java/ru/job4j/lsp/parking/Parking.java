package ru.job4j.lsp.parking;
import java.util.Map;
/**
 * Interface Parking.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public interface Parking {
    /**
     * Method adds vehicle.
     */
    void add(Vehicle vehicle);
    /**
     * Method returns filling up  parking.
     */
    Map<Place,Vehicle> getMapParking();
}
