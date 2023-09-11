package ru.job4j.search;

public class Task  {
    /**
     * Хранит описание приоретета.
     */
    private String desc;
    /**
     * Хранит номер приоретета.
     */
    private int priority;
    /**
     * Конструктор для активации полей.
     * @param desc описание приоретета.
     * @param priority номер приоретета.
     */

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }
    /**
     * Метод возвращает описание приоретета .
     * @return описание приоретета.
     */

    public String getDesc() {
        return desc;
    }
    /**
     * Метод возвращает номер приоретета .
     * @return номер приоретета.
     */

    public int getPriority() {
        return priority;
    }

}
