package ru.job4j.statistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Analize.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Analize {
    /**
     * Метод - сравнивает элементы двух массивов.
     * @param previous - начальный массив.
     * @param current - текущий массив.
     * @return info - объект с информацией изменения.
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, String> mapOfPrevious = new HashMap<>();
        Map<Integer, String> mapOfCurrent = new HashMap<>();
        for (User prevElement : previous) {
            mapOfPrevious.put(prevElement.getId(), prevElement.getName());
        }
        for (User curElement : current) {
            mapOfCurrent.put(curElement.getId(), curElement.getName());
        }
        for(Integer key : mapOfPrevious.keySet()) {
            if (!mapOfCurrent.containsKey(key)) {
                info.deleted++;
            } else if (!mapOfCurrent.get(key).equals(mapOfPrevious.get(key))) {
                info.changed++;
            }
        }
            for (Integer key : mapOfCurrent.keySet()) {
                if (!mapOfPrevious.containsKey(key)) {
                   info.added++;
                }
        }
            return info;
    }
    /**
     * User - внутрений класс, дженерик массивов.
     * @author Vovk Alexander  vovk.ag747@gmail.com
     * @version $Id$
     * @since 0.1
     */
    public static class User {
        /**
         * Поле - хранит id пользователя.
         */
       private int id;
        /**
         * Поле - хранит имя пользователя.
         */
       private String name;
        /**
         * Конструктор для активации полей пользователя.
         * @param name имя пользователя.
         * @param id пользователя.
         */
       public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
        /**
         * Метод возвращает id пользователя.
         * @return id пользователя.
         */
        public int getId() {
            return this.id;
        }
        /**
         * Метод возвращает имя пользователя.
         * @return имя пользователя.
         */
        public String getName() {
            return this.name;
        }
    }
    /**
     * Info - внутрений класс, хранит изменения в текущем массиве.
     * @author Vovk Alexander  vovk.ag747@gmail.com
     * @version $Id$
     * @since 0.1
     */
    public static class Info {
        /**
         * Поле - хранит статистику добавления.
         */
        int added;
        /**
         * Поле - хранит статистику изменения.
         */
        int changed;
        /**
         * Поле - хранит статистику удаления.
         */
        int deleted;
        /**
         * Конструктор пустой.
         */
        public Info() {
        }
        /**
         * Конструктор для активации полей пользователя.
         * @param added добавление.
         * @param changed изменение.
         * @param deleted удаление.
         */
        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added && changed == info.changed && deleted == info.deleted;
        }
        @Override
        public int hashCode() {
            int result = 31 * added;
            result = 31 * result + changed;
            result = 31 * result + deleted;
            return result;
        }
    }
}
