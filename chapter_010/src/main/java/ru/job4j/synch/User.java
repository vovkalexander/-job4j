package ru.job4j.synch;
/**
 * User.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class User {
    /**
     * Field - stores link of integer.
     */
    private   int id;
    /**
     * Field - stores link of integer.
     */
    private int amount;
    /**
     * Constructor for activation fields.
     */

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }
    /**
     * The method returns field's id.
     * @return integer
     */

    public int getId() {
        return id;
    }
    /**
     * The method returns field's amount.
     * @return integer
     */

    public int getAmount() {
        return amount;
    }
    /**
     * The method activates field's amount.
     * @param amount integer.
     */

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
