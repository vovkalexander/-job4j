package ru.job4.tracker.playchess;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import org.junit.Before;
import ru.job4j.playchess.*;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopTest {
    private Board board;
    boolean result = false;
    @Before
    public void startUp() {
        board = new Board();
        board.add(new Bishop(Cell.A1));
    }
    @Test
    public void whenFigureNotFound() {
        try {
            result = board.move(Cell.B3, Cell.D4);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        }
        assertThat(result, is(false));
    }
    @Test
    public void whenBishopCanMove() {
        try {
            result = board.move(Cell.A1, Cell.C3);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        }
        assertThat(result, is(true));
    }
    @Test
    public void whenBishopMoveWrong() {
        try {
            result = board.move(Cell.A1, Cell.B4);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(false));
        }
    }
}


