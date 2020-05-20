package ru.job4j.isp.menu;
import java.io.InputStream;
import java.util.Scanner;
/**
 * BaseAction.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class BaseAction {
    /**
     * Field - stores link of class Menu.
     */
    Menu wood;
    /**
     * Field - stores link of class Scanner.
     */
    Scanner scan;
    /**
     * Constructor for activation fields.
     */
    public BaseAction(InputStream stream, Menu wood) {
        this.wood = wood;
        this.scan = new Scanner(stream);
    }
    /**
     * Method  operates with user.
     */
    public void init() {
        String input;
        do {
            wood.showMenu();
            input = this.scan.nextLine();
            if (wood.orderedMenu().contains(input)) {
                System.out.println("You have chosen " + input);
            } else if(!input.matches("exit")) {
                System.out.println("Choose correct item ");
            }
        } while (!input.equals("exit"));

    }
    public static void main(String[] args) {
        Menu menu = new Menu("Menu");
        menu.add("Menu", "Task 1");
        menu.add("Menu", "Task 2");
        menu.add("Task 1", "Task 1.1");
        menu.add("Task 1", "Task 1.2");
        menu.add("Task 2", "Task 2.1");
        menu.add("Task 2", "Task 2.2");
        menu.add("Task 2.1", "Task 2.1.1");
        menu.add("Task 2.1", "Task 2.1.2");
        BaseAction conversation = new BaseAction(System.in,menu);
        conversation.init();
    }
}
