package ru.job4j.lsp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
/**
 * ControllQuality.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ControllQuality {
    /**
     * Field - activate object of list.
     */
    private List<Storage> storageSet = new ArrayList<>();
    /**
     * The method adds object Scorage to list;
     */
    public void addStorage(Storage storage) {
        storageSet.add(storage);
    }
    /**
     * The method distributes products by quality to storage;
     */
    public boolean checkStorage(Food food) throws ParseException {
        boolean rst = false;
        for (Storage storage: storageSet) {
            if (storage.addFood(food)) {
                rst = true;
                break;
            }
        }
        return rst;
    }
}
