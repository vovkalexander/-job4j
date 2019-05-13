package ru.job4j.playchess;

import java.util.stream.IntStream;

/**
 * Board - описывает шахматную доску.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * хранит кол-во фигур.
     */
    private int place;
    /**
     * массив хранит все фигуры на доске.
     */
   private Figure[] figures = new Figure[32];
    /**
     * Метод - добавляет фигуру на доску.
     * @param figure- шахматная фигура.
     * @return - возвращает фигуру.
     */
    public Figure add(Figure figure) {
        this.figures[place++] = figure;
        return figure;
    }
    /**
     * Метод выполняет перемещение фигуры по доске.
     * @param source начальная позиция фигуры.
     * @param dest  конечная позиция фигуры.
     * @return возвращает логический вывод(правельное перемещение фигуры).
     * @throws ImpossibleMoveException Выбрасывает исключение, если фигуру нельзя передвинуть в указанную точку.
     * @throws OccupiedWayException    Выбрасывает исключение, если движению фигуры  мешают другие фигуры.
     * @throws FigureNotFoundException Выбрасывает исключение, если на начальной позиции нет фигуры.
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        Figure figure = figures[index];
        Cell[] steps = figure.way(source, dest);
        if (!located(figure, steps)) {
            figures[index] = figure.copy(dest);
            rst = true;
        }
        return rst;
    }
    /**
     * Метод проверяет нахожденние фигуры по начальной точки.
     * @param sourse начальная положение фигуры .
     * @return логический вывод.
     * @throws FigureNotFoundException Выбрасывает исключение, если в начальной позиции нет фигуры.
     */
    public int findBy(Cell sourse) throws FigureNotFoundException {
        return IntStream.range(0,this.figures.length).filter(index ->figures[index] != null && figures[index].position.x == sourse.x
                && figures[index].position.y == sourse.y).findFirst().orElseThrow(() -> new  FigureNotFoundException("На клетке отсутсвует фигура"));
    }
    /**
     * Метод проверяет, свободен ли путь движения фигуры.
     * @param figure текущая фигура.
     * @param steps Список ячеек, через которые пройдет фигура.
     * @return логический вывод.
     * @throws OccupiedWayException Выбрасывает исключение, если движению фигуры  мешают другие фигуры.
     */
    private boolean located(Figure figure, Cell[] steps) throws OccupiedWayException {
        boolean result = false;
        for (int i = 0; i < figures.length; i++) {
            for (int j = 0; j < steps.length; j++) {
                if (figures[i] != null && figures[i].position.x == steps[j].x && figures[i].position.y == steps[j].y) {
                    result = true;
                    break;
                }
            }
        }
        if (result) {
            throw new OccupiedWayException("Клетка занята");
        }
        return result;
    }
}