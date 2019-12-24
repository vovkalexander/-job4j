package ru.job4j.departments;
import java.util.*;
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
     *
     * @param deps список департаментов.
     */
    public Departments(List<String> deps) {
        this.deps = deps;
    }

    /**
     * Метод разбивает департамент на подразделения.
     *
     * @param deps- список департаментов.
     * @return список департаментов с набором подразделений.
     */
    public Set<String> convert(List<String> deps) {
        Set<String> newList = new TreeSet<>();
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
     *
     * @param deps- список департаментов.
     * @return отсортированный список департаментов.
     */
    public List<String> sortAsc(List<String> deps) {
        Set<String> straightSort = convert(deps);
        return new ArrayList<>(straightSort);
    }
    /**
     * Метод сортирует департаменты по возрастанию.
     *
     * @param deps- список департаментов.
     * @return отсортированный список департаментов.
     */
    public List<String> sortDesc(List<String> deps) {
        Set<String> straightSort = convert(deps);
        Set<String> reverseSort = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int letter = 0;
                int i = 0;
                for (i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                    letter = Character.compare(o2.charAt(i), o1.charAt(i));
                    if (letter != 0) {
                        return letter;
                    }
                }
                return Integer.compare(o1.length(), o2.length());
            }
        });
        reverseSort.addAll(straightSort);
        return new ArrayList<>(reverseSort);
    }
}
