package ru.job4j.srp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
/**
 * InteractCalc.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class InteractCalc {
    /**
     * Field - store link for object of ExtendedCalc.
     */
    private ExtendedCalc calculator;
    /**
     * Field - store link for object of  Input.
     */
    Input input;
    /**
     * Field - store link for object of  Input.
     */
    private final Consumer<String> output;
    /**
     * Field - activate object of list.
     */
    private  List<Integer> range = new ArrayList<>();
    /**
     * Field - store link for object of  ActionFactory.
     */
    ActionFactory factory;
    /**
     * Field - store variable of double.
     */
    Double result;
    /**
     .
     */
    public InteractCalc(Input input, ExtendedCalc calculator, Consumer<String> output) {
        this.calculator=calculator;
        this.output=output;
        this.input=input;
        factory=new ActionFactory();

    }
    /**
     * The method accepts variables users, makes calculation and records result.
     */
    public void init() {
        for (int i = 0; i < factory.getActionCount(); i++) {
            range.add(i);
        }
        while (true){
            this.display();
            Action action = factory.createOperation(input.ask("select:", range));
            if (action == null) {
                break;
            }
            PerformOperation.execute(calculator, action);
        }

    }
    /**
     * The method which displays menu.
     */
    public void display() {
        output.accept("Choose 0-4 for calculation or put finish for ending "+
                System.getProperty("line.separator")+
                "0- add, 1- sub, 2- mult, 3 - divid");
    }
    /**
     * The method returns result of calculation.
     * @return result - double of calculation.
     */
    public Double getResult() {
        this.result = calculator.getResult();
        return result;
    }

    public static void main(String[] args) {
        InteractCalc inter =  new InteractCalc(new ValidateInput(new ConsoleInput(System.in)), new ExtendedCalc(), System.out::println);
        inter.init();
        inter.getResult();
    }
}
