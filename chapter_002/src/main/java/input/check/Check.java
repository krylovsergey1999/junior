package input.check;

import java.io.*;
import java.math.BigInteger;

public class Check {
    boolean isNumber(InputStream in) {
        try (BufferedInputStream input = new BufferedInputStream(in)) {
            int el = 0;
            while (input.available() > 0) {
                el = input.read();
            }
            char c = (char) el;
            int value = Integer.parseInt(String.valueOf(c));
            if (value % 2 == 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }
}
