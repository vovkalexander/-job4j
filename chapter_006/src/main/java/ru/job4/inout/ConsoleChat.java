package ru.job4.inout;
import java.io.*;
import java.util.*;
/**
 * ConsoleChat.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ConsoleChat {
    /**
     * Поле - поток консольного ввода.
     */
    private Scanner in;
    /**
     * Поле - хранит список переписки.
     */
    private List<String> link = new LinkedList<>();
    /**
     * Поле - хранит путь к файлу записи диалога.
     */
    private String parent = System.getProperty("user.dir") + File.separator + "test.txt";
    /**
     * Конструктор  для активации консольного потока
     * @param stream поток ввода.
     */
    public ConsoleChat(InputStream stream) {
        this.in = new Scanner(stream);

    }
    /**
     * Конструктор  для активации консольного потока
     * @param input  строки пользователя.
     */
    public ConsoleChat(String input) {
        this.in = new Scanner(input);

    }
    /**
     * Метод возвращает файл с исключающем расширением .
     * @return список переписки.
     */
    public List<String> getList() {
        return this.link;
    }
    /**
     * Метод загружает список выражений ответчика.
     * @param logic - выключатель потока ответчика.
     * @return список выражений ответчика.
     */
    public List<String> load(Boolean logic) throws IOException {
        List<String> list = new ArrayList<>();
        Boolean rst = true;
        try (BufferedReader read = new BufferedReader(new FileReader(this.parent))) {
            if (rst == logic) {
                String string;
                while ((string = read.readLine()) != null) {
                    list.add(string);
                }
            } else {
                read.close();
                list.clear();
            }
        }
        return list;
    }
    /**
     * Метод записывает переписку в файл.
     * @param list - список переписки.
     * @param  path - путь к файлу
     */
    public void writeDown(List<String> list, String path) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            for (String string : list) {
                out.write(string + System.lineSeparator());
            }
        }

    }
    /**
     * Метод создает переписку.
     */
    public void setUp() throws IOException {
        Boolean check = true;
        String scan;
        String answer;
        while (in.hasNext() && !(scan = in.next()).equals("закончить")) {
            link.add(scan);
            if (scan.equals("стоп")) {
                check = false;
            }
            if (scan.equals("продолжить")) {
                check = true;
            }
            List<String> array = load(check);
            Collections.shuffle(array);
            for (int i = 0; i < array.size(); i++) {
                answer = array.get(i);
                System.out.println(answer);
                link.add(answer);
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        ConsoleChat chat = new ConsoleChat(System.in);
        chat.setUp();
        chat.writeDown(chat.getList(), System.getProperty("user.dir") + File.separator + "result.txt");
    }
}



