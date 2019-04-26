package map.three;


import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Krylov Sergey
 */
public class Main {
    // Переопределение hashCode
    public static void main(String[] args) {
        User one = new User("petr", 10, new GregorianCalendar(2019, 0, 20));
        User two = new User("petr", 10, new GregorianCalendar(2019, 0, 20));
        Map<User, Object> map = new HashMap<User, Object>();
        map.put(one, "qwerty");
        map.put(two, "uiop");
        for (Map.Entry<User, Object> el : map.entrySet()) {
            System.out.println(el.getValue());
        }
    }
}
