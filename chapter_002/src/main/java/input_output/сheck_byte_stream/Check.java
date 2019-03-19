package input_output.сheck_byte_stream;

import java.io.*;

public class Check {
    boolean isNumber(InputStream in) {
        try (DataInputStream din = new DataInputStream(new BufferedInputStream(in))) {
            int value = din.readInt();
            if (value % 2 == 0) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
