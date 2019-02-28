package ru.job4j.tracker;
/**
 * ValidateInput.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput implements  Input {
    /**
     * Хранит переменную итерфейса.
     */
    private final Input input;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     */
    public ValidateInput(final Input input) {
        this.input = input;
    }
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
    @Override
    public int ask(String question, int[] range) {
       boolean invalid = true;
       int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException  moe) {
                System.out.println("please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
