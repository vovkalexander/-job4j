package ru.job4j.srp;



/**
 * ActionFactory.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public  class ActionFactory {
    /**
     * Field - store link for object of Action.
     */
    Action action;
    /**
     * The method sets up object of operation.
     * @param choose - string putting by users.
     * @return Action - object of class object.
     */
    public Action createOperation(int choose) {
        if (choose==0) {
            action = new Addition();
        } else if (choose==1) {
            action = new Subtracting();
        } else if (choose==2) {
            action = new Multiplication();
        } else if (choose==3) {
            action = new Dividing();
        } else  {
            action = null;
        }
        return action;
    }
    /**
     * The method returns quality of operations .
     * @return number - quality of operations.
     */
    int getActionCount(){return 4;};
}
