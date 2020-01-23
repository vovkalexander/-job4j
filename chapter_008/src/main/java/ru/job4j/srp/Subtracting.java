package ru.job4j.srp;
import ru.job4j.calculator.Calculator;
import java.util.List;
import java.util.Scanner;
/**
 * Subtracting.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Subtracting implements Action {
    @Override
    public void operation(Scanner scan, Calculator calc, List<Double> list) {
        Double d;
        String str;
        this.display();
        while (scan.hasNext(Action.REGEX)) {
            str = scan.next();
            if (str.equals("r")) {
                d = calc.getResult();
                list.add(d);
            } else {
                list.add(Double.parseDouble(str));
            }
            if (list.size() == 2) {
                calc.subtract(list.get(0), list.get(1));
                System.out.println("Result is  " + calc.getResult());
                list.clear();
                break;
            } else {
                this.display();
            }
        }
    }
    public void display() {
        System.out.println("put number or r - last result");
    }
}
