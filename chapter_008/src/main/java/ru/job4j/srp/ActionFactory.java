package ru.job4j.srp;
/**
 * ActionFactory.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public  class  ActionFactory {
    /**
     * Field - store link for object of Action.
     */
    Action action;
    /**
     * The method sets up object of operation.
     * @param choose - string putting by users.
     * @return Action - object of class object.
     */
    public Action createOperation(String choose) {
        if (choose.equals("+")) {
           action = new Addition();
        } else if (choose.equals("-")) {
            action = new Subtracting();
        } else if (choose.equals("*")) {
            action = new Multiplication();
        } else if (choose.equals("/")) {
            action = new Dividing();
        }
        return action;
    }
}
