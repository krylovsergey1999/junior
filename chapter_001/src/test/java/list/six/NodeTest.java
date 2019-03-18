package list.six;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NodeTest {
    Node first;
    Node two;
    Node third;
    Node four;

    @Before
    public void beforeTest() {
        first = new Node(1);
        two = new Node(2);
        third = new Node(3);
        four = new Node(4);
    }

    @Test
    public void whenHasNotCycle() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertTrue(Node.hasCycle(first));
    }

    @Test
    public void whenHasCycle() {
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = null;
        assertTrue(Node.hasCycle(first));
    }
}
