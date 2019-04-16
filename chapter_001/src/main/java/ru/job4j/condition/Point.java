package ru.job4j.condition;

/**
 * Point.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @since 20.01.2019
 * @version 1
 */

public class    Point {
    /**
     * Contains X coordinate.
     */
    private int x;
    /**
     * Contains Y coordinate.
     */
    private int y;

    /**
     * Constructor class Point .
     * @param x coordinate.
     * @param y coordinate.
     */

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Calculate distance .
     * @param that - second point.
     * return distance.
     *
     */

    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }
    /**
     * Main .
     * @param args- args.
     */


    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        double result = a.distanceTo(b);
        System.out.println(" The distance between points A and B is: " + result);

    }

}

