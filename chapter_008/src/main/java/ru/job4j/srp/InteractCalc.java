package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
     * Field - store variable of double.
     */
    Double result;
    /**
     * Constructor for activation fields.
     * @param calculator - link for class Calculator.
     * @param stream - link for class InputStream.
     */
    public InteractCalc(Calculator calculator, InputStream stream) {
        this.calculator = calculator;
        this.in = new Scanner(stream);
    }
    /**
     * The method accepts variables users, makes calculation and records result.
     */
    public void chooseCategory() throws IOException {
        String scan;
        double d = 0.0;
        boolean switchOff = true;
        do {
            this.display();
            String str = in.next();
            if (str.equals("+")) {
                System.out.println("put number or r - last result");
                while (in.hasNext("[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]|r")) {
                    scan = in.next();
                    if (scan.equals("r")) {
                        d = calculator.getResult();
                        list.add(d);
                    } else {
                        list.add(Double.parseDouble(scan));
                    }
                    if (list.size() == 2) {
                        calculator.add(list.get(0), list.get(1));
                        System.out.println("Result is  " + calculator.getResult());
                        list.clear();
                        break;
                    }
                    System.out.println("put number or r - last result");
                }
            } else if (str.equals("-")) {
                System.out.println("put number or r - last result");
                while (in.hasNext("[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]|r")) {
                    scan = in.next();
                    if (scan.equals("r")) {
                        d = calculator.getResult();
                        list.add(d);
                    } else {
                        list.add(Double.parseDouble(scan));
                    }
                    if (list.size() == 2) {
                        calculator.subtract(list.get(0), list.get(1));
                        System.out.println("Result is  " + calculator.getResult());
                        list.clear();
                        break;
                    }
                    System.out.println("put number or r - last result");
                }
            } else if (str.equals("*")) {
                System.out.println("put number or r - last result");
                while (in.hasNext("[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]|r")) {
                    scan = in.next();
                    if (scan.equals("r")) {
                        d = calculator.getResult();
                        list.add(d);
                    } else {
                        list.add(Double.parseDouble(scan));
                    }
                    if (list.size() == 2) {
                        calculator.multiple(list.get(0), list.get(1));
                        System.out.println("Result is  " + calculator.getResult());
                        list.clear();
                        break;
                    }
                    System.out.println("put number or r - last result");
                }
            } else if (str.equals("/")) {
                System.out.println("put number or r - last result");
                while (in.hasNext("[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]|r")) {
                    scan = in.next();
                    if (scan.equals("r")) {
                        d = calculator.getResult();
                        list.add(d);
                    } else {
                        list.add(Double.parseDouble(scan));
                    }
                    if (list.size() == 2) {
                        calculator.div(list.get(0), list.get(1));
                        System.out.println("Result is  " + calculator.getResult());
                        list.clear();
                        break;
                    }
                    System.out.println("put number or r - last result");
                }
            }else if (str.equals("finish")) {
                switchOff = false;
            }else {
                System.out.println("put correct input");
            }
        } while(switchOff);
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
        return this.result = calculator.getResult();
    }

    public static void main(String[] args) throws IOException {
        Calculator cal = new Calculator();
        InteractCalc inter = new InteractCalc(cal, System.in);
        inter.chooseCategory();
    }
}
