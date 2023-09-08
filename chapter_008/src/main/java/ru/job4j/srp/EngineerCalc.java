package ru.job4j.srp;
import java.util.function.Consumer;
/**
 * EngineerCalc.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class EngineerCalc extends InteractCalc {
    /**
     * Constructor for activation fields.
     */
    public EngineerCalc(Input input, ExtendedCalc calculator, Consumer<String> output) {
        super(input, calculator, output);
    }

    @Override
    public void initCalculator() {
        super.getPattern().load(8, super.getPattern().toSin());
        super.getPattern().load(9, super.getPattern().toCos());
        super.getPattern().load(10, super.getPattern().toTan());
        super.getPattern().load(11, super.getPattern().toCtg());
        super.getPattern().load(-1, super.getPattern().toFinish());
    }

    @Override
    public void display() {
        super.output.accept("Choose  for calculation or put finish for ending "
                +
                System.getProperty("line.separator")
                +
                "8- Sin, 9- Cos, 10 - Tan, 11 - Ctg");
    }

    public static void main(String[] args) {
        EngineerCalc enCalc = new EngineerCalc((new ConsoleInput(System.in)), new ExtendedCalc(), System.out::println);
        enCalc.init();
        enCalc.getResult();
    }
}
