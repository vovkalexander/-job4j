package ru.job4j.srp;
import java.util.function.Consumer;

public class TripleInteractCalc extends InteractCalc {
    /**
     * Constructor for activation fields.
     */
    public TripleInteractCalc(Input input, ExtendedCalc calculator, Consumer<String> output) {
        super(input, calculator, output);
    }
    @Override
    public void initCalculator() {
        super.getPattern().load(5, super.getPattern().toTripAdd());
        super.getPattern().load(6, super.getPattern().toTripSub());
        super.getPattern().load(7, super.getPattern().toTripMul());
        super.getPattern().load(-1, super.getPattern().toFinish());
    }
    @Override
    public void display() {
        super.output.accept("Choose  for calculation or put finish for ending "+
                System.getProperty("line.separator")+
                "5- tripadd, 6- tripsub, 7- tripmult");
    }
    public static void main(String[] args) {
        TripleInteractCalc trip = new TripleInteractCalc((new ConsoleInput(System.in)), new ExtendedCalc(), System.out::println );
        trip.init();
        trip.getResult();
    }
}
