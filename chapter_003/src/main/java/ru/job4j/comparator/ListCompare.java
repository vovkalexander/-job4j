package ru.job4j.comparator;
import java.util.Comparator;
/**
 * ListCompare.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ListCompare implements Comparator<String> {
    /**
     * compare-метод сравнивает две строчки по символу. .
     * @param left - строка символов.
     * @param right - строка символов.
     * @return целочисленное число.
     */
    @Override
    public int compare(String left, String right) {
        int index = 0;
        int letter = 0;

        while (index < Math.min(left.length(), right.length())) {
            letter = Character.compare(left.charAt(index), right.charAt(index));
            if (letter != 0) {
                break;
            }
            if (letter == 0) {

                letter = Integer.compare(left.length(), right.length());
            }
            index++;
        }
        return letter;
    }
}

