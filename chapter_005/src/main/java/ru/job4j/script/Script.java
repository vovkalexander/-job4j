package ru.job4j.script;
import java.util.*;
/**
 * Script.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Script {
    /**
     * Метод - возвращает список всех скриптов .
     * @param map - карта зависимости скриптов.
     * @param scriptId - закрузочный скрипт.
     * @return список взаимозависимых скриптов.
     */
    public List<Integer> load(Map<Integer, List<Integer>> map, Integer scriptId) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(scriptId);
        Set<Integer> tree = new TreeSet<>();
        tree.add(scriptId);
        while (!queue.isEmpty()) {
            List<Integer> list = map.get(queue.poll());
            for (Integer integer : list) {
                if (map.containsKey(integer))
                    queue.offer(integer);
                    tree.add(integer);
            }
        }
        return new ArrayList<>(tree);
    }
}
