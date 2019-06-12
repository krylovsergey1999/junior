package input.archive;

public class Args {
    public static String directory(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                return args[i + 1];
            }
        }
        return null;
    }

    public static void excule() {

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
