package list.five;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {
    SimpleQueue<Integer> queue;

    @Before
    public void beforeTest() {
        queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
    }

    @Test
    public void whenPoll() {
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }
}
