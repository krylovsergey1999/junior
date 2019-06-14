package input.archive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    // seek - искать
    public List<File> seekBy(File file, String excule) {
        ArrayList<File> list = new ArrayList<>();
        if (file.getName().endsWith(excule)) {
            return list;
        }
        if (file.isDirectory()) {
            list.add(file);
            for (File el : file.listFiles()) {
                list.addAll(seekBy(el, excule));
            }
        } else {
            list.add(file);
        }
        return list;
    }

    public void pack(List<File> sources, File target) throws IOException {
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(target));
        for (File elem : sources) {
            String substring = elem.getPath();
            zipFile(elem, substring, zipOut);
        }
        zipOut.close();
    }

    private void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
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

    public static void main(String[] args) throws IOException {
        String source = Args.directory(args).get();
        String target = Args.output(args).get();
        String excule = Args.excule(args).get();

        File fileToSource = new File(source);
        File fileToOut = new File(target);

        List<File> files = new Zip().seekBy(fileToSource, excule);
        new Zip().pack(files, fileToOut);
    }
}