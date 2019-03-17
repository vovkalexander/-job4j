package ru.job4j.playchess;
import static java.lang.Integer.*;
import static ru.job4j.playchess.Cell.findCell;
/**
 * Bishop - описывает движения офицера.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Bishop extends Figure {
    /**
     * Конструтор инициализирующий поля.
     * @param position позиция фигуры.
     */
    public Bishop(Cell position) {
        super(position);
    }
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Фигура не может так ходить!");
        }
        Cell[] steps = new Cell[Math.abs(dest.x - source.x)];
        int deltaX = compare(dest.x, source.x);
        int deltaY = compare(dest.y, source.y);
        int stepX = 0;
        int stepY = 0;
        for (int i = 1; i <= steps.length; i++) {
            stepX = source.x + (deltaX * i);
            stepY = source.y + (deltaY * i);
            steps[i - 1] = findCell(stepX, stepY);
        }
        return steps;
    }
    /**
     * Метод проверяет  движение фигуры по диагонали.
     * @param source - начальная точка положения фигуры.
     * @param dest - конечная точка положение фигуры.
     * @return - возвращает путь равной диагонали.
     */
    private boolean isDiagonal(Cell source, Cell dest) {
       return (Math.abs(dest.y - source.y) == Math.abs(dest.x - source.x));
    }
    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
