package ru.job4j.playchess;
/**
 * Figure - абстрактный класс.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public abstract class Figure {
    /**
     * Позиция фигуры.
     */
    private final Cell position;
    /**
     * Конструтор инициализирующий поля.
     * @param position номер пункта меню.
     */

    public Figure(Cell position) {
        this.position = position;
    }
    /**
     * Метод - указывающий путь фигуры.
     * @param source начальная позиция фигуры.
     * @param dest конечная позиция фигуры.
     * @return Массив ячеек, по которым пройдет фигура.
     * @throws ImpossibleMoveException Выбрасывает исключение,
     * если фигуру нельзя передвинуть в указанную точку.
     */

    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    public Cell getPosition() {
        return position;
    }
    /**
     * Метод - возвращающий новую фигуру с конечной позицией.
     * @param dest Конечная позиция фигуры.
     * @return Новую фигуру.
     */

    public abstract Figure copy(Cell dest);

}
