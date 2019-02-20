package ru.job4j.shapes;
/**
 * Paint.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * draw-Метод реализаущий построение фигуры.
     * @param shape - объект фигуры.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
    /**
     * Main Запуск программы(построение фигур)
     * @param args
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }
}
