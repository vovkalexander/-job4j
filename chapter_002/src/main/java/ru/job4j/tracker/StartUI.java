package ru.job4j.tracker;
/**
 * StartUI.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case ADD: this.createItem();
                    break;
                case SHOW: this.showAllItems();
                    break;
                case EDIT: this.editItem();
                    break;
                case DELETE: this.removeItem();
                    break;
                case FINDBYID: this.findById();
                    break;
                case FINDBYNAME: this.findByName();
                    break;
                case EXIT: exit = true;
                    break;
                default :
                    System.out.println("Пункт в меню отсуствует");
            }
        }
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
        Item[] items = this.tracker.findByName(name);
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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

