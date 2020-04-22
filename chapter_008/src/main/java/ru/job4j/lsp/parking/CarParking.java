package ru.job4j.lsp.parking;
import java.util.Map;
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
   private Map<Place, Vehicle> park;
    /**
     * Constructor for activation fields.
     */
   public CarParking(Map<Place, Vehicle> park) {
       //ToDo
   }
   @Override
    public void add(Vehicle vehicle) {
    }
    @Override
    public Map<Place, Vehicle> getMapParking() {
        return park;
    }
}
