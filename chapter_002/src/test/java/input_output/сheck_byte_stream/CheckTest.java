package input_output.сheck_byte_stream;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CheckTest {
    Check obj;

    @Before
    public void beforeTest() {
        obj = new Check();
    }

    @Test
    public void whenIsNotNumber() {
        InputStream in = new ByteArrayInputStream("q".getBytes(StandardCharsets.UTF_8));
        assertFalse(obj.isNumber(in));
    }

    @Test
    public void whenIsNumber() {
        InputStream in = new ByteArrayInputStream("12".getBytes(StandardCharsets.UTF_8));
        assertTrue(obj.isNumber(in));
    }

    @Test
    public void whenIsNumberTwo() {
        InputStream in = new ByteArrayInputStream("1ф".getBytes(StandardCharsets.UTF_8));
        assertFalse(obj.isNumber(in));
    }
    @Test
    public void whenIsNumberThree() {
        InputStream in = new ByteArrayInputStream("q1".getBytes(StandardCharsets.UTF_8));
        assertFalse(obj.isNumber(in));
    }
}
