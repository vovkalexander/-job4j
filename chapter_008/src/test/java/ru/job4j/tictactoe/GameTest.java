package ru.job4j.tictactoe;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * GameTest
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class GameTest {
    @Test
    public void winByDiagonalWithNormalSize() {
        Board board = new ModifyBoard(3);
        char[][] che = {{'x','.','.'},
                        {'.','x','.'},
                        {'.','.','x'}} ;
        board.set(che);
        Game game = new Game(board,4);
        assertThat(game.play(), is (true));
    }
    @Test
    public void winByVerticalWithSubstandardSize() {
        Board board = new ModifyBoard(4);
        char[][] array = {{'x','.','.','.'},
                          {'x','.','.','.'},
                          {'x','.','.','.'},
                          {'x','.','.','.'}};
        board.set(array);
        Game game = new Game(board,4);
        assertThat(game.play(), is (true));
    }
    @Test
    public void winByHorizontalWithSubstandardSize() {
        Board board = new ModifyBoard(5);
        char[][] array = {{'.','.','.','.','.'},
                          {'x','x','x','x','x'},
                          {'.','.','.','.','.'},
                          {'.','.','.','.','.'},
                          {'.','.','.','.','.'}};
        board.set(array);
        Game game = new Game(board,4);
        assertThat(game.play(), is (true));
    }
}
