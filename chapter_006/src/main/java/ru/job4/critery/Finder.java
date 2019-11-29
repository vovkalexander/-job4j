package ru.job4.critery;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Finder.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Finder {
    /**
     * Поле - хранит ссылку класса MyFileVisitor.
     */
    MyFileVisitor mfv;
    /**
     * Метод - поиска  файлов после выбронной категории пользователя и записи в файл.
     * @param  args массив аргументов командной строки.
     */
    public void search(String[] args) throws IOException {
         mfv = new MyFileVisitor(args);
        try {
            Files.walkFileTree(Paths.get(mfv.setup), mfv);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        Finder find = new Finder();
        find.search(args);
    }
}
