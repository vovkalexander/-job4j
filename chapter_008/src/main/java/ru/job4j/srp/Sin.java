package ru.job4j.srp;
import ru.job4j.calculator.Calculator;
import java.util.List;
import java.util.Scanner;
/**
 * Sin.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Sin  implements Action {
    @Override
    public void operation(Scanner scan, Calculator calc, List<Double> list) {
        Double d;
        String str;
        this.display();
        while (scan.hasNext(Action.REGEX)) {
            str = scan.next();
            if (str.equals("r")) {
                d = calc.getResult();
            } else {
                d = Double.parseDouble(str);
            }
            calc.setResult(Math.sin(d));
            System.out.println("Result is  " + calc.getResult());
            break;
        }
    }
    public void display() {
        System.out.println("put number or r - last result");
    }
}
