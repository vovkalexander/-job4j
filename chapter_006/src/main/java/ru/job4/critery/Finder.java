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
    private  MyFileVisitor mfv;
    /**
     * Конструктор  для активации полей
     * @param args массив аргументов командной строки.
     */
    public Finder (String[] args) throws IOException {
        mfv = new MyFileVisitor(args);
    }
    /**
     * Метод - возвращает ссылку класса MyFileVisitor.
     * @return ссылка класса MyFileVisitor.
     */
    public MyFileVisitor getMfv() {
        return this.mfv;
    }
    /**
     * Метод - поиска  файлов после выбронной категории пользователя и записи в файл.
     */
    public void search() {
        try {
            Files.walkFileTree(Paths.get(mfv.getSetup()), mfv);
            this.mfv.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        Finder find = new Finder(args);
        find.search();
    }
}
