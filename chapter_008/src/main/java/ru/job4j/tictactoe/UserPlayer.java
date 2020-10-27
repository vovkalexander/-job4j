package ru.job4j.tictactoe;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * UserPlayer.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class UserPlayer implements Player {
    /**
     * Field - stores char value .
     */
    private   char SIGN_X = 'x';
    /**
     * Field - stores the object of class Scanner.
     */
    private   Scanner scanner = new Scanner(System.in);

    @Override
    public void turn(Board board) {
        int x, y;
        do {
            System.out.println(
                    System.lineSeparator() + "Enter X and Y (1.." + board.getSize() + ")");
            if (scanner.hasNextInt()) {
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } else {
              throw  new InputMismatchException("the type is incongruous");
            }
        }  while (!board.addMark(x, y, SIGN_X));
    }

    @Override
    public char getMark() {
        return this.SIGN_X;
    }
}
