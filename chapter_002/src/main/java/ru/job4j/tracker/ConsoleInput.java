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
}
