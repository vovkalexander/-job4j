package ru.job4j.lsp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Shop.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Shop implements Storage {
    /**
     * Field - store link of class List.
     */
    private List<Food> list;
    /**
     * Constructor for activation fields.
     */

    public Shop() {
        list = new ArrayList<>();
    }
    /**
     * The method which accepts object of class Food as long as product expire date is suitable to a range and sets up
     * discount of product if necessary.
     * @param food - link of class Food.
     */

    public boolean addFood(Food food) {
        boolean rst = false;
        int percent = food.dateDifference();
        if (percent >= 25 && percent <= 75) {
            list.add(food);
            rst = true;
        } else if (percent > 75 && percent < 100) {
            food.setDiscount(food.getDiscount());
            list.add(food);
            rst = true;
        }
        return rst;
    }
    /*
     * The method returns list of food objects.
     * @return list - field list.
     */

    public List<Food> getList() {
        return list;
    }
    /*
     * The method makes list into queue and returns.
     * @return queue of food's object.
     */

    public Queue<Food> recordIntoQueue() {
        Queue<Food> queue = new LinkedList<>(this.getList());
        this.getList().clear();
        return queue;
    }
}