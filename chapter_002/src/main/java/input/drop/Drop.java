package input.drop;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Drop {
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(in));
             PrintWriter output = new PrintWriter(out)) {
            final String[] line = new String[1];
            while ((line[0] = input.readLine()) != null) {
                Stream<String> stream = Arrays.stream(abuse);
                stream.forEach(el -> line[0] = line[0].replace(el, ""));
                output.write(line[0]);
            }
        }
    }
}
