package input.archive;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void pack(List<File> sources, File target) {
        for (File elem : sources) {
            pack(elem, target);
        }
    }

    // seek - искать
    public static List<File> seekBy(File file) {
        ArrayList<File> list = new ArrayList<>();
        if (file.isDirectory()) {
            list.add(file);
            for (File el : file.listFiles()) {
                list.addAll(seekBy(el));
            }
        } else {
            list.add(file);
        }
        return list;
    }

    public void pack(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                int available = out.available();
                for (int i = 0; i < available; i++) {
                    zip.write(out.read());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("./chapter_002");
        if (file.exists()) {
            new Zip().pack(seekBy(file), new File("./chapter_002/pom.zip"));
        }
    }
}