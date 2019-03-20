package input.check;

import java.io.*;

public class Check {
    boolean isNumber(InputStream in) {
        try (BufferedInputStream input = new BufferedInputStream(in)) {
            int el = 0;
            while (input.available() > 0) {
                el = input.read();
                if ((el < 48) | (el > 57)) {
                    return false;
                }
            }
            char c = (char) el;
            int value = Integer.parseInt(String.valueOf(c));
            if (value % 2 == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
