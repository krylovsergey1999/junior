package input.drop;

import org.junit.Test;
import org.junit.Before;

import java.io.*;

import static junit.framework.TestCase.assertTrue;

public class DropTest {
    InputStream in;
    OutputStream out;
    InputStream inread;
    String[] abuse;
    Drop ob;

    @Before
    public void beforeTest() throws FileNotFoundException {
        System.out.println();
        in = new FileInputStream(new File("src/test/java/input/drop/test.txt"));
        out = new FileOutputStream(new File("src/test/java/input/drop/out.txt"));
        inread = new FileInputStream(new File("src/test/java/input/drop/out.txt"));
        abuse = new String[]{"1", "2", "3", "4", "5"};
        ob = new Drop();
    }

    @Test
    public void whenDrop() throws IOException {
        int read;
        StringBuilder otvet = new StringBuilder();
        ob.dropAbuses(in, out, abuse);
        InputStreamReader el = new InputStreamReader(inread);
        while ((read = el.read()) != -1) {
            otvet.append((char) read);
        }
        assertTrue(otvet.toString().equals("qwerty67890"));
    }
}
