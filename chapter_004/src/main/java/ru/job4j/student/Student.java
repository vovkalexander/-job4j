package ru.job4j.student;
/**
 * Student.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Student implements  Comparable<Student> {
    /**
     * Хранит имя пользователя.
     */
    private String name;
    /**
     * Хранит бал пользователя.
     */
    private int score;
    /**
     * Конструктор для активации полей.
     * @param name имя пользователя.
     * @param score  бал пользователя.
     */

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    /**
     * Метод возвращает имя пользователя.
     * @return имя пользователя.
     */

    public String getName() {
        return name;
    }
    /**
     * Метод возвращает бал пользователя.
     * @return бал пользователя.
     */

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student one) {
         int rst = Integer.compare(this.score, one.score);
        return rst != 0 ? rst : this.name.compareTo(one.name);
    }
}
