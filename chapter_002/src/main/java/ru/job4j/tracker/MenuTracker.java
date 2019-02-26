package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;
/**
 * MenuTracker.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }
    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add program"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    /**
     *  Класс - пункт подменю добавление заявки
     */
    private class AddItem implements UserAction {
        /**
         * @param хранит номер пункта меню .
         */
        int key;
        /**
         * @param хранит название пункта меню .
         */
        String name;
        /**
         * Конструтор инициализирующий поля.
         * @param key номер пункта меню.
         * @param name название пункта меню.
         */
        public AddItem(int key, String name) {
            this.key = key;
            this.name = name;
        }
        @Override
        public int key() {
            return 0;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDescription());
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }
    /**
     *  Класс - пункт подменю показ всех заявок
     */
    private class ShowItems implements UserAction {
        /**
         * @param хранит номер пункта меню .
         */
        int key;
        /**
         * @param хранит название пункта меню .
         */
        String name;
        /**
         * Конструтор инициализирующий поля.
         * @param key номер пункта меню.
         * @param name название пункта меню.
         */
        public ShowItems(int key, String name) {
            this.key = key;
            this.name = name;
        }
        @Override
        public int key() {
            return 1;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ All Items --------------");
            for (Item item : tracker.findAll()) {
                if (item != null) {
                    System.out.println("Item with name:" + item.getName() + " " + "ID :" + item.getId());
                }
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }
    /**
     *  Класс - пункт подменю редактирование заявки
     */
    private class UpdateItem implements UserAction {
        /**
         * @param хранит номер пункта меню .
         */
        int key;
        /**
         * @param хранит название пункта меню .
         */
        String name;
        /**
         * Конструтор инициализирующий поля.
         * @param key номер пункта меню.
         * @param name название пункта меню.
         */
        public UpdateItem(int key, String name) {
            this.key = key;
            this.name = name;
        }
        @Override
        public int key() {
            return 2;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Edit item --------------");
            String id = input.ask("Initiate Item's id :");
            Item item = tracker.findById(id);
            if (item != null) {
                String newName = input.ask("Initiate new name :");
                item.setName(newName);
                String newDesc = input.ask("Initiate new description :");
                item.setDescription(newDesc);
                System.out.println("Item with new name" + item.getName() + "Item with new desc" + item.getDescription());
            } else {
                System.out.println("Item by Id" + id + "not found");
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }
    /**
     *  Класс - пункт подменю удаление заявки
     */
    private class DeleteItem implements UserAction {
        /**
         * @param хранит номер пункта меню .
         */
        int key;
        /**
         * @param хранит название пункта меню .
         */
        String name;
        /**
         * Конструтор инициализирующий поля.
         * @param key номер пункта меню.
         * @param name название пункта меню.
         */
        public DeleteItem(int key, String name) {
            this.key = key;
            this.name = name;
        }
        @Override
        public int key() {
            return 3;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------Removing  -------");
            String id = input.ask("Initiate item's id :");
            if (tracker.delete(id)) {
                System.out.println("Item removed");
            } else {
                System.out.println("Item by Id" + id + "not found");
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }
    /**
     *  Класс - пункт подменю поиск заявки по Id
     */
    private class FindItemById implements UserAction {
        /**
         * @param хранит номер пункта меню .
         */
        int key;
        /**
         * @param хранит название пункта меню .
         */
        String name;
        /**
         * Конструтор инициализирующий поля.
         * @param key номер пункта меню.
         * @param name название пункта меню.
         */
        public FindItemById(int key, String name) {
            this.key = key;
            this.name = name;
        }
        @Override
        public int key() {
            return 4;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------Finding item by ID -------");
            String id = input.ask("Initiate item's id :");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println("Item's name :" + item.getName());
            } else {
                System.out.println("Item by Id" + id + "not found");
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }
    }
    /**
     *  Класс - пункт подменю поиск заявки по имени
     */
    private class FindItemsByName implements UserAction {
        /**
         * @param хранит номер пункта меню .
         */
        int key;
        /**
         * @param хранит название пункта меню .
         */
        String name;
        /**
         * Конструтор инициализирующий поля.
         * @param key номер пункта меню.
         * @param name название пункта меню.
         */

        public FindItemsByName(int key, String name) {
            this.key = key;
            this.name = name;
        }
        @Override
        public int key() {
            return 5;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------Finding item by Name -------");
            String name = input.ask("Initiate item's name :");
            Item[] items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println("Item's name :" + item.getName() + " " + "ID :" + item.getId());
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }
    /**
     *  Класс - пункт подменю выход из главного меню
     */
    private class ExitProgram implements UserAction {
        /**
         * @param хранит номер пункта меню .
         */
        int key;
        /**
         * @param хранит название пункта меню .
         */
        String name;
        /**
         * Конструтор инициализирующий поля.
         * @param key номер пункта меню.
         * @param name название пункта меню.
         */
        public ExitProgram(int key, String name) {
            this.key = key;
            this.name = name;
        }
        @Override
        public int key() {
            return 6;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }
    }
}
