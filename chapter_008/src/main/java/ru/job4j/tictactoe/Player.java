package ru.job4j.tictactoe;
/**
 * interface Player.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public interface Player {
    /**
     * The method puts mark on Bord.
     * @param board - court for game.
     */

    void turn(Board board);
    /**
     * The method returns char.
     * @return  char.
     */

    char getMark();
}
