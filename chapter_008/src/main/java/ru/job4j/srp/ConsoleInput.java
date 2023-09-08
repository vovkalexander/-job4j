package ru.job4j.srp;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
/**
 * ConsoleInput.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    /**
     * Link scanner accepts  input data.
     */
    private Scanner scanner;
    /**
     * Constructor activates fields.
     * @param stream - input stream.
     */

    public ConsoleInput(InputStream stream) {
        this.scanner = new Scanner(stream);
    }
    /**
     * Method realizing request of users's parameters.
     * @param question - request to user.
     */

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    /**
     * Method implements a request of user's parameters , taking into account the range of the menu.
     * @param question - request to user.
     * @param range - list according to qua-ty items of menu.
     */

    public int ask(String question, List<Integer> range) throws ArrayIndexOutOfBoundsException {
        int key;
        String scan = this.ask(question);
        if (scan.equals("finish")) {
            key = -1;
        } else {
            key = Integer.valueOf(scan);
            boolean exist = false;
            for (int value : range) {
                if (value == key) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                throw new ArrayIndexOutOfBoundsException(); //("Out of menu range.");
            }
        }
        return key;
    }
}
