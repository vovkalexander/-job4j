package ru.job4j.departments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * ListCompare.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Departments {
    /**
     * Хранит список департаментов.
     */
    private final List<String> deps;
    /**
     * Конструктор для активации поля.
     * @param deps список департаментов.
     */
    public Departments(List<String> deps) {
        this.deps = deps;
    }

    /**
     * Метод разбивает департамент на подразделения.
     * @param deps- список департаментов.
     * @return список департаментов с набором подразделений.
     */
    public List<String> convert(List<String> deps) {
        List<String> newList = new ArrayList<>();
        for (String depart : deps) {
            StringBuilder structure = new StringBuilder();
            for (String codedivision : depart.split("\\\\")) {
                structure.append(codedivision);
                newList.add(structure.toString());
                structure.append("\\");
            }
        }
        return newList;
    }
    /**
     * Метод сортирует департаменты по убыванию.
     * @param deps- список департаментов.
     * @return отсортированный список департаментов.
     */
    public List<String> sortAsc(List<String> deps) {
        List<String> straightSort = convert(deps);
        Collections.sort(straightSort);
        return  straightSort;
    }
    /**
     * Метод сортирует департаменты по возрастанию.
     * @param deps- список департаментов.
     * @return отсортированный список департаментов.
     */
    public List<String> sortDesc(List<String> deps) {
        List<String> reverseSort = convert(deps);
        Collections.sort(reverseSort, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int letter = 0;
                int i = 0;
                for ( i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                    letter = Character.compare(o2.charAt(i), o1.charAt(i));
                    if (letter != 0) {
                        return letter;
                    }
                }
                return Integer.compare(o1.length(), o2.length());
            }
        });
        return reverseSort;
    }
}
