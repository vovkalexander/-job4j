package ru.job4j.srp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * PerformOperation.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class PerformOperation {
    /*
     * Field - stores object of Arraylist.
     */
  static  List<Double> list = new ArrayList<>();
    /*
     * Field - stores Link scanner accepts  input data.
     */
  static   Scanner scan = new Scanner (System.in);
    /*
     * The method  makes calculation.
     */
    public static void execute(ExtendedCalc calc, Action action) {
        Double d;
        String str;
        display();
        while (scan.hasNext(Action.REGEX)) {
            str = scan.next();
            if (str.equals("r")) {
                d = calc.getResult();
                list.add(d);
            } else {
                list.add(Double.parseDouble(str));
            }
            if (action.perform(calc, list) != null) {
                System.out.println("Result is  " + action.perform(calc, list));
                list.clear();
                break;
            } else {
                display();
            }
        }
    }
    /*
     * The method shows request to user.
     */
    private static void display() {
        System.out.println("put number or r - last result");
    }
}
