package map.user;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class UserTest {

    @Test
    public void whenUserEquals() {
        User one = new User("petr", 1, new Calendar(10));
        User two = new User("petr", 1, new Calendar(11));
        User three = new User("petr", 1, new Calendar(11));
        assertFalse(one.equals(two));
        assertTrue(two.equals(three));
    }

    @Test
    public void whenUserHashCode() {
        User one = new User("petr", 1, new Calendar(10));
        User two = new User("petr", 1, new Calendar(10));
        assertTrue(one.hashCode() == two.hashCode());
    }
}
