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
    public Place(String number,Integer size, Boolean occupied) {
        //ToDo;
    }
    /**
     * Method returns type of vehicle .
     */
    public int getSize() {
        return size;
    }
    /**
     * Method checks, place is occupied or not.
     */
    public Boolean getOccupied() {
        return occupied;
    }
    /**
     * Method sets up, place is occupied or not.
     */
    public void setOccupied(Boolean occupied) {
        //ToDo;
    }
    @Override
    public int hashCode() {
       //ToDo
    }
    @Override
    public boolean equals(Object o) {
        //ToDo
    }
}
