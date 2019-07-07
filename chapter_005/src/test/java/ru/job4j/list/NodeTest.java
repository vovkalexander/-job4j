package ru.job4j.list;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * NodeTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class NodeTest {
    @Test
    public void whenListIsClosedThenHasLoop() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(Node.hasCycle(first), is(true));
    }
    @Test
    public void whenListIsNotClosedThenHasNotLoop() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        five.next = null;
        assertThat(Node.hasCycle(first), is(false));
    }
}