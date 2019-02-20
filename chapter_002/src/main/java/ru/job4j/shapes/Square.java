package ru.job4j.shapes;
/**
 * Square.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
    /**
     * draw-Метод реализаущий изображение фигуры.
     */
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("*****\n");
        sb.append("*   *\n");
        sb.append("*****");
        return sb.toString();
    }
}
