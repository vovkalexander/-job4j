package ru.job4j.tictactoe;
/**
 * ModifyBoard.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ModifyBoard implements Board {
    /**
     * Field - stores char value .
     */
    private  char signEMPTY = '.';
    /**
     * Field - stores size of court.
     */
    private  int size;
    /**
     * Field - array of char improvising court.
     */
    private  char[][] table;
    /**
     * Constructor for activation fields.
     */

    public ModifyBoard(int size) {
        this.size = size;
        this.table = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                table[row][col] = signEMPTY;
            }
        }
    }

    @Override
    public void clean() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                table[row][col] = signEMPTY;
            }
        }
    }

    @Override
    public void printTable() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(table[row][col] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            System.out.println("out of bounds");
            return false;
        } else if (table[y][x] != signEMPTY) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isTableFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (table[row][col] == signEMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public   boolean checkWin(char dot) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == dot) {
                    count++;
                } else if (table[i][j] != dot) {
                    count = 0;
                    break;
                }
                if (count == size) {
                    return true;
                }
            }
        }
        if (count != size) {
            count = 0;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[j][i] == dot) {
                    count++;
                } else if (table[j][i] != dot) {
                    count = 0;
                    break;
                }
                if (count == size) {
                    return true;
                }
            }
        }
        if (count != size) {
            count = 0;
        }
        for (int i = 0; i < size; i++) {
            if (table[size - 1 - i][size - 1 - i] == dot) {
                count++;
            } else if (table[size - 1 - i][size - 1 - i] != dot) {
                count = 0;
                break;

            }
            if (count == size) {
                return true;
            }
        }
        if (count != size) {
            count = 0;
        }
        for (int i = 0; i < size; i++) {
            if  (table[i][size - 1 - i] == dot) {
                count++;
            } else if (table[i][size - 1 - i] != dot) {
                break;
            }
            if (count == size) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addMark(int x, int y, char position) {
        if (isCellValid(x, y)) {
            table[y][x] = position;
            return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void set(char[][] array) {
        this.table = array;
    }
}