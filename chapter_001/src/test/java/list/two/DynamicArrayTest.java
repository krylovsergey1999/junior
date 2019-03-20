package list.two;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class DynamicArrayTest {
    private DynamicArray<Integer> arr;
    Iterator<Integer> iter;

    @Before
    public void beforeTest() {
        arr = new DynamicArray<>(3);
        arr.add(1);
        arr.add(2);
        arr.add(5);
        iter = arr.iterator();
    }

    @Test
    public void addElem() {
        arr.add(9);
        assertThat(arr.getSize(), is(6));
    }

    @Test
    public void checkElem() {
        arr.add(19);
        assertNull(arr.get(4));
        assertThat(arr.get(3), is(19));
        assertThat(arr.get(2), is(5));
    }

    @Test
    public void checkException() {
        arr.add(20);
        try {
            iter.hasNext();
            Assert.fail();
        } catch (ConcurrentModificationException e) {
            System.out.println("Исключение поймано.");
            return;
        }
        Assert.fail();
    }
}
