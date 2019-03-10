package generic.one;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    private Iterator<String> it;
    SimpleArray<String> arr;

    @Before
    public void setUp() {
        arr = new SimpleArray<String>(10, String.class);
        arr.add("10");
        arr.add("11");
        arr.add("12");
        it = arr.iterator();
    }

    @Test
    public void whenAddGetSet() {
        assertThat(arr.get(1), is("11"));
        arr.set(0, "999");
        assertThat(arr.get(0), is("999"));
    }

    @Test
    public void whenIterator() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("10"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("11"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("12"));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenDelete() {
        arr.remove(1);
        assertThat(arr.get(1), is("12"));
    }
}
