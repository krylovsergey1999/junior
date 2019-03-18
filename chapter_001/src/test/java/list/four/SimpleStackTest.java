package list.four;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    SimpleStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void whenPop() {
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }
}
