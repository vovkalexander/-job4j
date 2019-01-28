package ru.job4j.loop;
/**
 * Board.
 * @author  Vovk Alexander (vovk.ag747@gmail.com).
 * @since 28.01.2019
 * @version 1
 */
public class Board {
    /**
     * Method paint.
     * @param width integer.
     * @param height integer.
     * @return screen string.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
