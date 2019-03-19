package input.check;

import java.io.*;

public class Check {
    boolean isNumber(InputStream in) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(in))) {
            String s = input.readLine();
            int x = Integer.parseInt(s);
            if (x % 2 == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
