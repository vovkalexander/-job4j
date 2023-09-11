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
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);
        assertThat(Node.hasCycle(first), is(true));
    }

    @Test
    public void whenListIsNotClosedThenHasNotLoop() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(five);
        five.setNext(null);
        assertThat(Node.hasCycle(first), is(false));
    }
}