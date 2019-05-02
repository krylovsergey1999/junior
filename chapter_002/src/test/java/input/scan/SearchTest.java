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
    String sep = File.separator;
    String dirStr = System.getProperty("java.io.tmpdir") + sep + "search";
    File dir = new File(dirStr);

    @Before
    public void create() throws IOException {
        dir.mkdir();
        File file1 = new File(dirStr + sep + "1");
        file1.mkdir();
        File file2 = new File(dirStr + sep + "2");
        file2.mkdir();
        File fileDir1Xml1 = new File(dirStr + sep + "1" + sep + "qwerty.xml");
        fileDir1Xml1.createNewFile();
        File fileDir1Txt = new File(dirStr + sep + "1" + sep + "qwerty.txt");
        fileDir1Txt.createNewFile();
        File fileDir2Txt = new File(dirStr + sep + "2" + sep + "qwerty2.txt");
        fileDir2Txt.createNewFile();
    }

    @Test
    public void whenSearchXML() {
        Search ob = new Search();
        List<String> list = new ArrayList<>();
        list.add(".xml");
        List<File> res = ob.files(dirStr, list);
        List<File> expected = new ArrayList<>();
        expected.add(new File(dirStr + sep + "1" + sep + "qwerty.xml"));
        assertTrue(res.containsAll(expected) && expected.containsAll(res));
    }

    @Test
    public void whenSearchTXT() {
        Search ob = new Search();
        List<String> list = new ArrayList<>();
        list.add(".txt");
        List<File> res = ob.files(dirStr, list);
        List<File> expected = new ArrayList<>();
        expected.add(new File(dirStr + sep + "1" + sep + "qwerty.txt"));
        expected.add(new File(dirStr + sep + "2" + sep + "qwerty2.txt"));
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
