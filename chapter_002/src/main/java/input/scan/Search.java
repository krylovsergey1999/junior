package input.scan;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import input.scan.BFS;
/**
 * @Author Krylov Sergey
 */


public class Search {
    /**
     * String parent - это путь до каталога, с которого нужно осуществлять поиск.
     *
     * List<String> exts - это расширения файлов, которые мы ходим получить.
     */

    public List<File> files(String parent, List<String> exts) {
        List<File> list = new ArrayList<File>();
        File root = new File(parent);
        Set<File> set = new BFS().bfs(root, exts);
        return new ArrayList<File>(set);
    }
}
