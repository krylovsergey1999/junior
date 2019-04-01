package map.user;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class UserTest {
    Calendar calendar1;
    Calendar calendar2;

    @Before
    public void before() {
        calendar1 = new GregorianCalendar(2017, 0, 25);
        calendar2 = new GregorianCalendar(2017, 0, 26);
    }

    @Test
    public void whenUserEquals() {
        User one = new User("petr", 1, calendar1);
        User two = new User("petr", 1, calendar2);
        User three = new User("petr", 1, calendar2);
        assertFalse(one.equals(two));
        assertTrue(two.equals(three));
    }

    @Test
    public void whenUserHashCode() {
        User one = new User("petr", 1, calendar1);
        User two = new User("petr", 1, calendar1);
        assertTrue(one.hashCode() == two.hashCode());
    }
}
