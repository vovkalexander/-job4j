package ru.job4j.srp;

import java.util.ArrayList;
import java.util.List;

/**
 * ValidateInput.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public abstract class ValidateInput implements Input {
    /**
     * Field - stores link of interface.
     */
    private final Input input;
    /**
     * Field - stores object of list.
     */
   private List<Double> list = new ArrayList<>();
    /**
     * Constructors activating fields.
     * @param input - user's data.
     */

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                if (value != -1) {
                    invalid = false;
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException  moe) {
                System.out.println("please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
    /**
     * Constructors activating fields.
     * @param calc - link of object ExtendedCalc.
     * @param action link of object  Action.
     */

    public  void execute(ExtendedCalc calc, Action action) {
        Double d;
        String str;
        do {
            try {
                str = input.ask("put number or r - last result:");
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
                }
            } catch (NumberFormatException nfe) {
                System.out.println("please enter number data again.");
            }
        } while (true);
    }
}
