package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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
    private final ITracker tracker;
    private final Consumer<String> output;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
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
        output.accept("Добавление новой заявки");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Метод реализует показ всех заявок.
     */
    private void showAllItems() {
        output.accept("-----------Все заявки------------");
        for (Item item : this.tracker.findAll()) {
            if (item != null) {
                output.accept("Имя заявки:" + item.getName() + " " + "ID :" + item.getId());
            }
        }
    }
    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        output.accept("---------Редактирование по ID -------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            String newName = this.input.ask("Введите новое имя :");
            item.setName(newName);
            String newDesc = this.input.ask("Введите новое описание :");
            item.setDescription(newDesc);
            output.accept("Заявка с новым именем" + item.getName() + "Заявка с новым описанием" + item.getDescription());
        } else {
            output.accept("Заявка по id" + id + "не найдена");
        }
    }
    /**
     * Метод реализует удаление заявки.
     */

    private void removeItem() {
        output.accept("---------Удаление  -------");
        String id = this.input.ask("Введите id заявки :");
        if (tracker.delete(id)) {
            output.accept("Заявка удалена");
        } else {
            output.accept("Заявка по id" + id + "не найдена");
        }
    }
    /**
     * Метод реализует нахождение заявки по id.
     */
    private void findById()  {
        output.accept("---------Нахождение заявки по ID -------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            output.accept("Имя заявки :" + item.getName());
        } else {
            output.accept("Заявка по id" + id + "не найдена");
        }
    }
    /**
     * Метод реализует нахождение заявки по имени.
     */
    private void findByName() {
        output.accept("---------Нахождение заявки по Имени -------");
        String name = this.input.ask("Введите имя заявки :");
       List<Item> items = this.tracker.findByName(name);
        for (Item item : items) {
            output.accept("Имя заявки :" + item.getName() + " " + "ID :" + item.getId());
        }
    }
    /**
     * Метод реализует показ списка меню.
     */
    private void showMenu() {
        output.accept("Меню.");
        output.accept("0-добавление новой заявки");
        output.accept("1-показ всех заявок");
        output.accept("2-редактирование заявок");
        output.accept("3-удаление заявки");
        output.accept("4-нахождение заявки по id");
        output.accept("5-нахождение заявки по имени");
        output.accept("6-выход из меню");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}

