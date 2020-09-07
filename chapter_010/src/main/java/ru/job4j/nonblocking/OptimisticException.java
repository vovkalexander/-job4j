package ru.job4j.nonblocking;
/**
 * OptimisticException.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class OptimisticException extends RuntimeException {
    /**
     * Constructor for activation fields.
     */

    public OptimisticException(String message) {
        super(message);
    }
}
