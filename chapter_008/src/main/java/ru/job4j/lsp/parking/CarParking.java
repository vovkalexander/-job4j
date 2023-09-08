package ru.job4j.lsp.parking;
import java.util.*;
/**
 * CarParking.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class CarParking implements Parking {
    /**
     * Field - stores collection  .
     */
    private  Map<Place, Vehicle> park;
    /**
     * Constructor for activation fields.
     */

    public CarParking(Map<Place, Vehicle> park) {
        this.park = park;
    }

    @Override
    public void add(Vehicle vehicle) {
        Place firstPlace;
        Place secondPlace;
        List<Place> keys = new ArrayList<>(park.keySet());
        for (int i = 0; i < keys.size(); i++) {
            firstPlace = keys.get(i);
            if (firstPlace.getSize() == vehicle.getSize() && !firstPlace.getOccupied()) {
                firstPlace.setOccupied(true);
                park.put(firstPlace, vehicle);
                break;
            }
            if (firstPlace != keys.get(keys.size() - 1)) {
                secondPlace = keys.get(i + 1);
                if ((firstPlace.getSize() + secondPlace.getSize()) == vehicle.getSize()
                        && !firstPlace.getOccupied() && !secondPlace.getOccupied()) {
                    firstPlace.setOccupied(true);
                    secondPlace.setOccupied(true);
                    park.put(firstPlace, vehicle);
                    park.put(secondPlace, vehicle);
                    break;
                }
            }
        }
    }

    @Override
    public Map<Place, Vehicle> getMapParking() {
        return park;
    }
}
