package ru.job4j.cofeemashine;
/**
 * CoffeeMachine.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class CoffeeMachine {
    /**
     * Хранит массив монет для сдачи.
     */
    private final int[] coins = new int[]{10, 5, 2, 1};
    /**
     * Метод выдачи сдачи кофемашины.
     * @param value купюра клиента.
     * @param price цена кофе.
     * @return сдача количеством монет с большим номиналом .
     */
    public int[] changes(int value, int price) {
        if (value < price) {
            throw new NotEnoughMoney("Недостаточное количество денег");
        }
        int[] coinsReturn = new int[]{0};
        int amount = value - price;
        if (amount > 0) {
            int count = 0;
            int[] countBack = new int[]{0, 0, 0, 0};
            for (int coin : coins) {
                while (amount - coin >= 0) {
                    amount -= coin;
                    countBack[count] = coin;
                    count++;
                }
                if (amount == 0) {
                    break;
                }
            }
            coinsReturn = new int[count];
            System.arraycopy(countBack, 0, coinsReturn, 0, count);
        }
        return coinsReturn;
    }
}
