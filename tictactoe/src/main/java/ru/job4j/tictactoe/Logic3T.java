package ru.job4j.tictactoe;
import java.util.function.Predicate;
/**
 * Logic3T.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Logic3T {
    /**
     * Хранит массив с клетками для игры.
     */
    private final Figure3T[][] table;
    /**
     * конструктор для инициализации  переменных поля.
     */

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }
    /**
     * Метод вычисляет последовательность расположения крестика и нолика .
     * @param predicate функциональный интерфейс условия.
     * @param startX начальная точка
     * @param startY начальная точка
     * @param deltaX движения
     * @param deltaY движения
     * @return логический вывод.
     */

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
    /**
     * Метод проверяет есть ли в поле выигрышные комбинации для Крестика.
     * @return логический вывод.
     */

    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) || this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) || this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1) || this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1) || this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0) || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, this.table.length - 1, -1, 0) || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, this.table.length - 1, 0, -1) || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1);

    }
    /**
     * Метод проверяет есть ли в поле выигрышные комбинации для Нолека.
     * @return логический вывод.
     */

    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) || this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) || this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1) || this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1) || this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0) || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, this.table.length - 1, 0, 0) || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, this.table.length - 1, 0, -1) || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    /**
     * Метод проверяет, если ли пустые клетки для новых ходов.
     * @return логический вывод.
     */
    public boolean hasGap() {
      return true;
    }
}

