package ru.job4.inout;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Analizy.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Analizy {
    /**
     * Метод - записывает в файл диапозон, когда сервер не работал.
     * @param source - файл регистрации событий сервера.
     * @param target - файл простоя сервера.
     */
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            boolean logic = true;
            String value;
            String line = null;
            List<String> list = new ArrayList<>();
            while ((line = read.readLine()) != null) {
                if (logic) {
                    if (line.contains("400") || line.contains("500")) {
                        value = line.substring(4);
                        list.add(value);
                        logic = false;
                    }
                }
                if (!logic) {
                    if (line.contains("200") || line.contains("300")) {
                        value = line.substring(4);
                        list.add(value);
                        logic = true;
                    }
                }
            }
            System.out.println(list);
            for (int i = 0; i < list.size(); i += 2) {
                System.out.println(list.size());
                if (list.size() % 2 == 0) {
                    out.write(String.join(";", list.get(i), list.get(i + 1)));
                    out.write(System.lineSeparator());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
