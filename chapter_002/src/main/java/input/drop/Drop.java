package input.drop;

import java.io.*;
import java.util.Scanner;

public class Drop {
    private int t;
    private StringBuilder s = new StringBuilder();

    void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        try (InputStreamReader input = new InputStreamReader(in);
             OutputStreamWriter output = new OutputStreamWriter((out))) {
            while ((t = input.read()) != -1) {
                char c = (char) t;
                s.append(c);
                for (String el : abuse) {
                    int l = s.indexOf(el);
                    int r = l + el.length();
                    if (l != -1) {
                        s.delete(l, r);
                    }
                }
            }
            output.write(s.toString());
        }
    }
}
