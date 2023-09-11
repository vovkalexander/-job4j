package ru.job4j.lsp.parking;
/**
 * Place.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Place {
    /**
     * Field- stores number place of parking .
     */
    private String number;
    /**
     * Field- stores type of vehicle  for location .
     */
    private int size;
    /**
     * Field- stores logic parameter.
     */
    private boolean occupied;
    /**
     * Constructor for activation fields.
     */

    public Place(String number, Integer size, Boolean occupied) {
        this.number = number;
        this.size = size;
        this.occupied = occupied;
    }
    /**
     * Method returns type of vehicle.
     */

    public int getSize() {
        return this.size;
    }
    /**
     * Method checks, place is occupied or not.
     */

    public Boolean getOccupied() {
        return this.occupied;
    }
    /**
     * Method sets up, place is occupied or not.
     */

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public int hashCode() {
        int result = this.number != null ? this.number.hashCode() : 0;
        result = 31 * result + this.size;
        return  result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Place place = (Place) o;
        return this.number.equals(place.number) && this.size == place.size;
    }
}

