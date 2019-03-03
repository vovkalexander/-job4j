package ru.job4j.tracker;
import java.util.*;
/**
 * ConsoleInput.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    /**
     * Переменная scanner принимает  входные данные.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Метод реализаущий запрос параметров пользователя.
     * @param question - запрос пользователю.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    /**
     * Метод реализаущий запрос параметров пользователя, c учетом диапозона меню.
     * @param question - запрос пользователю.
     * @param range - массив соответствующий кол-во пунктов меню.
     */
    public int ask(String question, int[] range)  {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}
