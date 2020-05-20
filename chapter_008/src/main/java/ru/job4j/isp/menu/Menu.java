package ru.job4j.isp.menu;
import java.util.*;
/**
 * Menu.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Menu implements SimpleMenu {
    /**
     * Field - stores link of class MenuItem.
     */
    MenuItem root;
    /**
     * Constructor for activation field.
     * @param value
     */
    public Menu(String value) {
        this.root = new MenuItem(value);
    }
    @Override
    public boolean add(String parent,  String child) {
        Optional<MenuItem> newNode = this.findBy(parent);
        if (newNode.isPresent()) {
            newNode.get().add(new MenuItem(child));
            return true;
        }
        return false;
    }
    @Override
    public Optional<MenuItem> findBy(String value) {
        Optional<MenuItem> rsl = Optional.empty();
        Queue<MenuItem> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            MenuItem el = data.poll();
            if (el.getName().equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (MenuItem child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }
    /**
     * Method puts in order list of Menu .
     */
    public final List<String> orderedMenu() {
        List<String> list = new ArrayList<>();
        Stack<MenuItem> queue = new Stack<>();
        queue.push(this.root);
        while (!queue.empty()) {
            MenuItem item = queue.pop();
            list.add(item.getName());
            for (MenuItem item1 : item.leaves())
                queue.push(item1);
        }
        Collections.sort(list);
        return list;
    }
    @Override
    public void showMenu() {
        this.display();
        for (String item : this.orderedMenu()) {
            System.out.println(item);
        }
    }
    /**
     * Method displays first command for user .
     */
    public void display() {
        System.out.printf("Choose item of menu or put %s%s%s%s%n", (char)34, "exit", (char)34,
                " for disconnecting");
    }
}
