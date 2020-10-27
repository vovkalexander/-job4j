package ru.job4j.tictactoe;
/**
 * interface Board.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public interface Board {
    /**
     * The method puts empty marks on cells.
     */

    void clean();
    /**
     * The method prints court on console.
     */

    void printTable();
    /**
     * The method checks suitable cells on court.
     * @param x - integer.
     * @param y - integer.
     */

    boolean isCellValid(int x, int y);
    /**
     * The method checks full cells on court .
     */

    boolean isTableFull();
    /**
     * The method checks winning position.
     * @param dot - char.
     */

    boolean checkWin(char dot);
    /**
     * The method puts on mark on cells of court.
     * @param x - integer.
     * @param y - integer.
     * @param position - char.
     */

    boolean addMark(int x, int y, char position);
    /**
     * The method returns size of court.
     * @return  integer.
     */

    int getSize();
    /**
     * The method sets up new court.
     * @param  array of char.
     */

    void set(char[][] array);
}
