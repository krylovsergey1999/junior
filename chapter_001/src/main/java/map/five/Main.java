package map.five;


import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Krylov Sergey
 */
public class Main {
    public static void main(String[] args) {
        User one = new User("petr", 10, new GregorianCalendar(2019, 0, 20));
        User two = new User("petr", 10, new GregorianCalendar(2019, 0, 20));
        Map<User, Object> map = new HashMap<User, Object>();
        map.put(one, "head");
        map.put(two, "body");
        for (Map.Entry<User, Object> el : map.entrySet()) {
            System.out.println(el.getValue());
        }
    }
}
