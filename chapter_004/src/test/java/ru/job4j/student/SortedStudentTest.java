package ru.job4j.student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortedStudentTest {
   private List<Student> list = new ArrayList<>();

    @Before
    public void fullList() {
        list = Arrays.asList(
                new Student("Kuzmitch", 45),
                new Student("Petrovitch", 65),
                null,
                new Student("Abramch", 25),
                null
              );
    }

    @Test
    public void whenPutMarkThenHasSortedList() {
        SortedStudent student = new SortedStudent();
        List<Student> result = student.levelOf(list, 50);
        Assert.assertThat(result.get(0).getName(), is("Abramch"));
        Assert.assertThat(result.get(1).getName(), is("Kuzmitch"));
    }

}
