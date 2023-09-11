package ru.job4j.tictactoe;
import java.util.Random;
/**
 * AIPlayer.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class AIPlayer implements Player {
    /**
     * Field - stores char value .
     */

    private char signO = 'o';
    /**
     * Field - stores the object of class Random.
     */
    private   Random random = new Random();

    @Override
    public void turn(Board board) {
        int x, y;
        do {
            x = random.nextInt(board.getSize());
            y = random.nextInt(board.getSize());
        } while (!board.addMark(x, y, signO));

    }

    @Override
    public char getMark() {
        return this.signO;
    }
}


