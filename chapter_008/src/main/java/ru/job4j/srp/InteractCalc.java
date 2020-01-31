package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InteractCalc {
    /**
     * Field - store link for object of Calculator.
     */
    private Calculator calculator;
    /**
     * Field - store link for object of  Scanner.
     */
    private Scanner in;
    /**
     * Field - activate object of list.
     */
    private final List<Double> list = new ArrayList<>();
    /**
     * Field - store link for object of  ActionFactory.
     */
    ActionFactory factory;
    /**
     * Field - store variable of double.
     */
    Double result;
    /**
     * Constructor for activation fields.
     */
    public InteractCalc() {
        this.calculator = new Calculator();
        this.in = new Scanner(System.in);
        this.factory = new ActionFactory();
    }
    /**
     * The method sets up criteria of calculation for users.
     * @return pattern - string for criteria of calculation.
     */
    public String setPattern() {
        String pattern = "[-+*/]";
        return pattern;
    }
    /**
     * The method accepts variables users, makes calculation and records result.
     */
    public void chooseCategory() throws IOException {
        boolean switchOff = true;
        do {
            this.display();
            String str = in.next();
            if (str.matches(this.setPattern())) {
                Action action = factory.createOperation(str);
                InteractCalc.execute(calculator, action, in, list);
            } else if (str.equals("finish")) {
                switchOff = false;
            }  else  {
                System.out.println("put correct input");
            }
        } while (switchOff);
    }
    /**
     * The method which displays menu.
     */
    public void display() {
        System.out.printf("%s%s%s%n", "Choose parameter for calculation or put finish for ending ",
                System.getProperty("line.separator"),
                "+, -, *, / ");
    }
    /**
     * The method which displays menu.
     * @param calc - link for object of Calculator.
     * @param action -link for object of Action.
     * @param list - link for object of List.
     */
    public static void execute(Calculator calc, Action action, Scanner scan, List<Double> list) {
        Double d;
        String str;
        displayExecute();
        while (scan.hasNext(action.REGEX)) {
            str = scan.next();
            if (str.equals("r")) {
                d = calc.getResult();
                list.add(d);
            } else {
                list.add(Double.parseDouble(str));
            }
            if (action.operation(calc, list) != null) {
                System.out.println("Result is " + action.operation(calc, list));
                list.clear();
                break;
            }
            displayExecute();
        }

    }

    public static   void displayExecute() {
        System.out.println("put number or r - last result");
    }
    /*
     * The method returns result of calculation.
     */
    public Double getResult() {
        this.result = calculator.getResult();
        return result;
    }
    public static void main(String[] args) throws IOException {
        InteractCalc inter = new InteractCalc();
        inter.chooseCategory();
    }

}
