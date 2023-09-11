package ru.job4j.lsp.parking;
/**
 * Truck.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Truck implements Vehicle {
    /**
     * Field- stores sort of vehicle .
     */
    private int type;
    /**
     * Constructor for activation fields.
     */

    public Truck(int type) {
        this.type = type;
    }

    @Override
    public int getSize() {
        return this.type;
    }
}
