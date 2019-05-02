package map.eigth;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @Author Krylov Sergey
 */

public class MyMapTest {
    MyMap<Integer, String> map;
    int size;

    @Before
    public void before() {
        map = new MyMap<>();
        size = 20;
        for (int i = 0; i < size; i++) {
            map.insert(i, new Integer(i).toString());
        }
    }

    @Test
    public void whenGet() {
        assertThat(map.get(16), is("16"));

        try {
            assertThat(map.get(20), is("20"));
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void whenDelete() {
        assertTrue(map.delete(17));
        assertThat(map.getSize(), is(size - 1));
    }

}