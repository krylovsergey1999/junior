package input.archive;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class Args {
    public static Optional<String> directory(String[] args) {
        String result = new String();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                String source = args[i + 1];
                String base = "C:\\Users\\krylo\\Documents\\junior";
                Path pathAbsolute = Paths.get(source);
                Path pathBase = Paths.get(base);
                Path relative = pathBase.relativize(pathAbsolute);
                result = relative.toString();
            }
        }
        return Optional.ofNullable(result);
    }

    public static Optional<String> excule(String[] args) {
        String result = new String();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-e")) {
                result = args[i + 1].substring(1);
            }
        }
        return Optional.ofNullable(result);
    }

    public static Optional<String> output(String[] args) {
        String result = new String();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-o")) {
                result =  args[i + 1];
            }
        }
        return Optional.ofNullable(result);
    }
}
