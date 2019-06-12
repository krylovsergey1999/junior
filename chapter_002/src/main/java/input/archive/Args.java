package input.archive;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Args {
    public static String directory(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                String source = args[i + 1];
                String base = "C:\\Users\\krylo\\Documents\\junior";
                Path pathAbsolute = Paths.get(source);
                Path pathBase = Paths.get(base);
                Path relative = pathBase.relativize(pathAbsolute);
                return relative.toString();
            }
        }
        return null;
    }

    public static String excule(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-e")) {
                return args[i + 1].substring(1);
            }
        }
        return null;
    }

    public static String output(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-o")) {
                return args[i + 1];
            }
        }
        return null;
    }
}
