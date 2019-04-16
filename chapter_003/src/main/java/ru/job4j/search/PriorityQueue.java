package ru.job4j.search;
import java.util.LinkedList;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PriorityQueue {
    /**
     * Хранит массив задач. .
     */
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод добавляет отсортированную задачу .
     * @param task задача.
     */
    public void put(Task task) {
        int i = tasks.size();
        int index = 0;
        while (index < tasks.size()) {
            if (tasks.get(index).getPriority() > task.getPriority()) {
                i = index;
                break;

            }
            index++;
        }
        tasks.add(index, task);
    }
    /**
     * Метод возвращает задачу с головы массива .
     * @return задачу и удаляет из массива.
     */
    public Task take() {
        return this.tasks.poll();
    }
}
