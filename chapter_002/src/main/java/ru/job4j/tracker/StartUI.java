package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * StartUI.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
    /**
     * Массив -  массив соответствующий кол-во пунктов меню.
     */
    List<Integer> range = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для показа всех заявок.
     */
    private static final String SHOW = "1";
    /**
     * Константа меню для редактирование заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаление заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для  нахождения заявки по id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для нахождения заявки по имени.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа меню для выхода из меню.
     */
    private static final String EXIT = "6";
    /**
     * Флажок для выхода.
     * Программа работает до тех пор, пока значение истинно.
     */
    private boolean working = true;
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", this.range));
        } while (this.working);
    }
    /**
     * Метод инкапсуляции переменной working.
     */
    public void stop() {
        this.working = false;
    }
    /**
     * Метод реализует добавление новый заявки в хранилище.
     */
    private void createItem()  {
        System.out.println("Добавление новой заявки");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Метод реализует показ всех заявок.
     */
    private void showAllItems() {
        System.out.println("-----------Все заявки------------");
        for (Item item : this.tracker.findAll()) {
            if (item != null) {
                System.out.println("Имя заявки:" + item.getName() + " " + "ID :" + item.getId());
            }
        }
    }
    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        System.out.println("---------Редактирование по ID -------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            String newName = this.input.ask("Введите новое имя :");
            item.setName(newName);
            String newDesc = this.input.ask("Введите новое описание :");
            item.setDescription(newDesc);
            System.out.println("Заявка с новым именем" + item.getName() + "Заявка с новым описанием" + item.getDescription());
        } else {
            System.out.println("Заявка по id" + id + "не найдена");
        }
    }
    /**
     * Метод реализует удаление заявки.
     */

    private void removeItem() {
        System.out.println("---------Удаление  -------");
        String id = this.input.ask("Введите id заявки :");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Заявка по id" + id + "не найдена");
        }
    }
    /**
     * Метод реализует нахождение заявки по id.
     */
    private void findById()  {
        System.out.println("---------Нахождение заявки по ID -------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Имя заявки :" + item.getName());
        } else {
            System.out.println("Заявка по id" + id + "не найдена");
        }
    }
    /**
     * Метод реализует нахождение заявки по имени.
     */
    private void findByName() {
        System.out.println("---------Нахождение заявки по Имени -------");
        String name = this.input.ask("Введите имя заявки :");
       List<Item> items = this.tracker.findByName(name);
        for (Item item : items) {
            System.out.println("Имя заявки :" + item.getName() + " " + "ID :" + item.getId());
        }
    }
    /**
     * Метод реализует показ списка меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0-добавление новой заявки");
        System.out.println("1-показ всех заявок");
        System.out.println("2-редактирование заявок");
        System.out.println("3-удаление заявки");
        System.out.println("4-нахождение заявки по id");
        System.out.println("5-нахождение заявки по имени");
        System.out.println("6-выход из меню");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}

