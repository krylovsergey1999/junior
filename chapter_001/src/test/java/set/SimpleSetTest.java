package set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    SimpleSet<Integer> set;

    @Before
    public void init() {
        set = new SimpleSet<>(5);
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    public void whenSize() {
        set.add(5);
        set.add(5);
        set.add(5);
        set.add(5);
        assertThat(set.getSize(), is(4));
    }

    @Test
    public void whenAddNull() {
        set.add(null);
        set.add(5);
        assertThat(set.getSize(), is(5));
    }

    @Test
    public void whenAddNullTwo() {
        set.add(null);
        set.add(null);
        assertThat(set.getSize(), is(4));
    }

    @Test
    public void whenIterator() {
        Iterator<Integer> iter = set.iterator();
        assertThat(iter.next(), is(1));
        assertThat(iter.next(), is(2));
    }
}
