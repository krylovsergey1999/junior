package input.chat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Chat {
    /*
    Состояние чата.
    1 - чат включен
    0 - чат не отвечает (stop)
    2 - чат выключаем
     */
    private int state;
    private static final String PATH = "chapter_002\\src\\main\\java\\input\\chat\\";


    /**
     * Метод запускает чат
     *
     * @param nameFileLog    - имя файла getLog
     * @param nameFilePhrase - ммя файла откуда брать ответ пользователю
     */
    public void start(String nameFileLog, String nameFilePhrase) throws IOException {
        BufferedWriter writer = getLog(nameFileLog);  // не забыть закрыть
        List<String> listPhrase = getListPhrase(nameFilePhrase);

        this.state = 1; // включаем чат
        Scanner sc = new Scanner(System.in);
        String log; // строка которую будем в логи отдавать

        while (state == 1 || state == 0) {
            String input = sc.nextLine();
            log = new Date().toString() + " : " + input + "\n";
            writer.write(log);

            state = handler(input, state);
            if (state == 1) {
                String phrase = "Answer: " + getRandomPhrase(listPhrase);
                System.out.println(phrase);
                log = new Date().toString() + " : " + phrase + "\n";
                writer.write(log);
            }
        }
        writer.close();
    }

    /**
     * Метод обрабатывает строку введеную пользователем
     *
     * @param s     - это строка считанная у пользователя
     * @param state
     * @return
     */
    private int handler(String s, int state) {
        switch (s) {
            case "stop": {
                state = 0; // чат не отвечает на сообщения
                break;
            }
            case "turn on": {
                state = 1; // чат работает в нормальном режиме
                break;
            }
            case "end": {
                state = 2; // чат выключаем
                break;
            }
        }
        return state;
    }

    /**
     * Метод отдает объект с помощью которого будем писать логи
     *
     * @param name - имя файла в который будем писать логи
     * @return
     * @throws IOException
     */
    private BufferedWriter getLog(String name) throws IOException {
        File file = new File(Chat.PATH + name);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        return writer;
    }

    private List<String> getListPhrase(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Chat.PATH + fileName));
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
        scanner.close();
        return list;
    }

    private String getRandomPhrase(List<String> phrase) {
        Random ran = new Random();
        int x = ran.nextInt(phrase.size());
        return phrase.get(x);
    }
}
