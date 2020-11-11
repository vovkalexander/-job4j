package ru.job4.tracker.playchess;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.playchess.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopTest {
    private Board board;
    private Bishop bishop;
    @Before
    public void startUp() {
        board = new Board();
        board.add(new Bishop(Cell.A1));
    }
    @Test
    public void whenFigureNotFound() throws FigureNotFoundException {
        Throwable exception = assertThrows(FigureNotFoundException.class, () -> board.move(Cell.B3, Cell.D4));
        assertEquals("На клетке отсутсвует фигура", exception.getMessage());
    }
    @Test
    public void whenBishopCanMove() {
        bishop = new Bishop(Cell.A1);
        Cell[] result = bishop.way(bishop.getPosition(), Cell.D4);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4};
        assertThat(result, is(expected));
    }
    @Test
    public void whenBishopMoveWrong() throws ImpossibleMoveException {
        Throwable exception = assertThrows(ImpossibleMoveException.class, () -> board.move(Cell.A1, Cell.B4));
        assertEquals("Фигура не может так ходить!", exception.getMessage());
    }
}


