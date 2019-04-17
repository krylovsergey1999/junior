package input.scan;

import java.io.File;
import java.util.*;

/**
 * @Author Krylov Sergey
 */
public class BFS {
    public Set<File> bfs(File file, List<String> exts) {
        Set<File> set = new HashSet<>();
        Queue<File> q = new LinkedList<>();
        q.add(file);
        while (!q.isEmpty()) {
            File el = q.poll();
            if (el.isDirectory()) {
                File[] l = el.listFiles();
                if (l.length > 0)
                    for(File f: el.listFiles()){
                        q.add(f);
                    }
            } else
            for(String element: exts) {
                if (el.getName().endsWith(element)){
                    set.add(el);
                    break;
                }
            }
        }
        return set;
    }
}
