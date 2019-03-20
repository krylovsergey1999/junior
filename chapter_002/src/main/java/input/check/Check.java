package input.check;

import java.io.*;
import java.math.BigInteger;

public class Check {
    boolean isNumber(InputStream in) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(in))) {
            String s = input.readLine();
            BigInteger x = new BigInteger(s);
            if (x.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
