package ru.job4j.student;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * SortedStudent.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SortedStudent {
    /**
     * Метод сортирует список студентов по балу в аттестате.
     * @param students список студентов.
     * @param bound средний бал.
     * @return сортированный список.
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return   students.stream().flatMap(Stream::ofNullable).sorted().
                takeWhile(student -> student.getScore() < bound).collect(Collectors.toList());
    }
}
