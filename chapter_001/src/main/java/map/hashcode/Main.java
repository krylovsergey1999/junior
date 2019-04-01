package map.hashcode;

import map.user.User;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User one = new User("petr", 10, new GregorianCalendar(2019, 0, 20));
        User two = new User("petr", 10, new GregorianCalendar(2019, 0, 20));
        Map<User, Object> map = new HashMap<User, Object>();
        map.put(one, "one");
        map.put(two, "two");
        for (Map.Entry<User, Object> el : map.entrySet()) {
            System.out.println(el.getValue());
        }
    }
}
