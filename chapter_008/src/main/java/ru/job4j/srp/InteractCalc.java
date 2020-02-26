package ru.job4j.srp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

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
   private ValidateInput in;
    /**
     * Field - store link for object of  Input.
     */
   protected Consumer<String> output;
    /**
     * Field - activate object of list.
     */
    private  List<Integer> range = new ArrayList<>();
    /**
     * Field - store variable of double.
     */
   private Double result;
    /**
     * Field - store object of DispatchAction.
     */
   private DispatchAction pattern = new DispatchAction();
    /**
     * Constructor for activation fields.
     */
    public InteractCalc(Input input, ExtendedCalc calculator, Consumer<String> output) {
        this.calculator=calculator;
        this.output=output;
        in=new ValidateInput(input) {
            @Override
            public String ask(String question) {
                return super.ask(question);
            }
        };
        this.initCalculator();
    }
    /*
     * The method loads objects of Action for calculation in DispatchAction .
     */
    public void initCalculator() {
        pattern.load(-1, pattern.toFinish());
        pattern.load(0, pattern.toAddition());
        pattern.load(1, pattern.toSubtracting());
        pattern.load(2, pattern.toMultiplication());
        pattern.load(3, pattern.toDividing());
    }
    /**
     * The method accepts variables users, makes calculation and records result.
     */
    public void init() {
        this.initCalculator();
        for (Map.Entry<Integer, Function<Integer, Action>> entry: pattern.getDispatch().entrySet()) {
            range.add(entry.getKey());
        }
        while (true){
            this.display();
            Action action = pattern.sent(in.ask("select:", range));
            if (action == null) {
                break;
            }
            in.execute(calculator, action);
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
    public DispatchAction getPattern() {
        return this.pattern;
    }
    public static void main(String[] args) {
        InteractCalc inter =  new InteractCalc((new ConsoleInput(System.in)), new ExtendedCalc(), System.out::println);
        inter.init();
        inter.getResult();
    }
}
