package list.three;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class LinkListTest {
    LinkList<Integer> list;
    Iterator<Link<Integer>> it;

    @Before
    public void beforeTest() {
        list = new LinkList<>();
        list.insertFirst(10);
        list.insertFirst(15);
        list.insertFirst(20);
        it = list.iterator();
    }

    @Test
    public void whenGetFirst() {
        assertThat(list.get(2), is(15));
    }

    @Test
    public void whenDeleteFirst() {
        assertThat(list.deleteFirst(), is(20));
    }

    @Test
    public void whenIteratorHasNextOne() {
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenIteratorHasNextTwo() {
        it.next();
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenIteratorHasNextThree() {
        it.next();
        it.next();
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenIteratorHasNextFour() {
        it.next();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenIteratorNext() {
        assertThat(it.next().getDate(), is(20));
    }
}
