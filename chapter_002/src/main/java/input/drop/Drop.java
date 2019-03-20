package input.drop;

import java.io.*;
import java.util.Scanner;

public class Drop {
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(in));
             PrintWriter output = new PrintWriter(out)) {
            String line;
            while ((line = input.readLine()) != null) {
                for (String el : abuse) {
                    if (line.contains(el)) {
                        line = line.replace(el, "");
                    }
                }
                output.write(line);
            }
        }
    }
}
