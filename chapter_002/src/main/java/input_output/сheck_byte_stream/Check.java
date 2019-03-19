package input_output.сheck_byte_stream;

import java.io.*;

public class Check {
    boolean isNumber(InputStream in) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(in))) {
            String s = input.readLine();
            int x = Integer.parseInt(s);
            if (x % 2 == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
