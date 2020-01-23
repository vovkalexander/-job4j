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
     * @param calculator - link for class Calculator.
     * @param stream - link for class InputStream.
     * @param factory - link for class ActionFactory.              .
     */
    public InteractCalc(Calculator calculator, InputStream stream, ActionFactory factory) {
        this.calculator = calculator;
        this.in = new Scanner(stream);
        this.factory = factory;
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
                action.operation(in, calculator, list);
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
     * The method returns result of calculation.
     */
    public Double getResult() {
        this.result = calculator.getResult();
        return result;
    }
    public static void main(String[] args) throws IOException {
        Calculator cal = new Calculator();
        ActionFactory factory = new ActionFactory();
        InteractCalc inter = new InteractCalc(cal, System.in, factory);
        inter.chooseCategory();
    }

}
