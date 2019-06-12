package input.archive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
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

    public static void main(String[] args) throws IOException {
        //String source = "./chapter_002/src/main";
        String directory = "C:\\Users\\krylo\\Documents\\junior";
        String source = directory;
        String target = Args.output(args);
        System.out.println(source);
        File fileToSource = new File(source);
        System.out.println(fileToSource.getPath());
        File fileToOut = new File(target);

        List<File> files = seekBy(fileToSource);
        pack(files, fileToOut);
    }

    public static void pack(List<File> sources, File target) throws IOException {
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(target));
        for (File elem : sources) {
            String substring = elem.getPath();
            //.substring(2);
            zipFile(elem, substring, zipOut);
        }
        zipOut.close();
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        System.out.println(fileName);
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("\\")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "\\"));
                zipOut.closeEntry();
            }
            return;
        } else {
            FileInputStream in = new FileInputStream(fileToZip);
            zipOut.putNextEntry(new ZipEntry(fileName));
            byte[] bytes = new byte[in.available()];
            zipOut.write(bytes);
            in.close();
        }
    }
}