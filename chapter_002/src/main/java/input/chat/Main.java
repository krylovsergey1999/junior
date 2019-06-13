package input.chat;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        new Chat().start("log.txt", "answer.txt");
    }
}
