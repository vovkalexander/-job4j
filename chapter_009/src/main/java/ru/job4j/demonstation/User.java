package ru.job4j.demonstation;
/**
 * User.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class User {
    /**
     * Field - stores int value.
     */
    private int id;
    /**
     * Field - stores link for object of  String.
     */
    private String name;
    /**
     * Field - stores link for object of  String.
     */
    private String city;
    /**
     * Empty constructor.
     */

    public User() {
    }
    /**
     * Overloaded Constructor for activation 2 fields.
     */

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    /**
     * Overloaded Constructor for activation 3 fields.
     */

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
       System.out.println("Object has been destroyed");
    }

    @Override
    public String toString() {
        return "User{"
                +
                "name='" + name + '\''
                +
                '}';
    }
    /**
     * Method makes big quality Object of class.
     * @param limit - primitive variable.
     */

    public void method(int limit) {
        info();
        for (int index = 0; index < limit; index++) {
            new User(1, "Pupkin", "City");
        }
        info();
    }
    /**
     * Method displays information about heap.
     */

    public  void info() {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Heap performs statistics [MB] ");
        System.out.println("Used Memory:" + (runtime.totalMemory() - runtime.freeMemory()) / mb);
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);
        System.out.println("Maximum Memory:" + runtime.maxMemory() / mb);
    }

    public static void main(String[] args) {
        User user = new User();
        user.method(10000000);
    }
}
