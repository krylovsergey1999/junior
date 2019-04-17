package input.scan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * @Author Krylov Sergey
 */

public class SearchTest {
    String dir_str = System.getProperty("java.io.tmpdir") + "\\search";
    File dir = new File(dir_str);

    @Before
    public void create() throws IOException {
        dir.mkdir();
        File file1 = new File(dir_str + "\\1");
        file1.mkdir();
        File file2 = new File(dir_str + "\\2");
        file2.mkdir();
        File file_dir_1_xml1 = new File(dir_str + "\\1" + "\\qwerty.xml");
        file_dir_1_xml1.createNewFile();
        File file_dir_1_txt = new File(dir_str + "\\1" + "\\qwerty.txt");
        file_dir_1_txt.createNewFile();
        File file_dir_2_txt = new File(dir_str + "\\2" + "\\qwerty2.txt");
        file_dir_2_txt.createNewFile();
    }

    @Test
    public void whenSearchXML() {
        Search ob = new Search();
        List<String> list = new ArrayList<>();
        list.add(".xml");
        List<File> res = ob.files(dir_str, list);
        List<File> expected = new ArrayList<>();
        expected.add(new File(dir_str + "\\1" + "\\qwerty.xml"));
        assertTrue(res.containsAll(expected) && expected.containsAll(res));
    }

    @Test
    public void whenSearchTXT() {
        Search ob = new Search();
        List<String> list = new ArrayList<>();
        list.add(".txt");
        List<File> res = ob.files(dir_str, list);
        List<File> expected = new ArrayList<>();
        expected.add(new File(dir_str + "\\1" + "\\qwerty.txt"));
        expected.add(new File(dir_str + "\\2" + "\\qwerty2.txt"));
        assertTrue(res.containsAll(expected) && expected.containsAll(res));
    }


    @After
    public void after() {
        deleteFolder(dir);
    }

    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();

    }
}
