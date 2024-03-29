package ru.job4j.condition;
/**
 * Triangle.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @since 20.01.2019
 * @version 1
 */

public class Triangle {
    /**
     * Contains a coordinate.
     */
    private Point a;
    /**
     * Contains b coordinate.
     */
    private Point b;
    /**
     * Contains c coordinate.
     */
    private Point c;

    /**
     * Constructor class Point .
     * @param a coordinate.
     * @param b coordinate.
     * @param c coordinate.
     */

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     * Формула.
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Перимент.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }
    /**
     * Метод вычисления площади треугольника.
     * @return Площадь.
     */

    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {

            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));

        }
        return rsl;
    }
    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return boolean правда или ложь.
     */

    private boolean exist(double ab, double ac, double bc) {

        return ab + bc > ac && ab + ac > bc && ac + bc > ab;

    }
}