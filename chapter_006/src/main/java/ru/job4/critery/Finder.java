package ru.job4.critery;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
/**
 * Finder.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Finder {
    /**
     * Поле - хранит список файлов результа поиска.
     */
   private List<Path> result;
    /**
     * Поле - хранит ссылку класса Arg.
     */
    private Arg arg;
    /**
     * Конструктор  для активации полей
     * @param args массив аргументов командной строки.
     */

    public Finder(String[] args) throws IOException {
        arg = new Arg(args);
        arg.chooseCategory();
    }
    /**
     * Метод - поиска  файлов после выбронной категории пользователя и добавление в список.
     */

    public void search() throws IOException {
        PredicateFactory factory = new PredicateFactory();
        Predicate predicate = factory.createSearch(arg.getMap().get("name"), arg);
        result = predicate.execute(arg);
    }
    /**
     * Метод - записывает список файлов в удаленный файл.
     */

    public void write() throws IOException  {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(arg.getMap().get("output")))) {
            for (Path path : this.result) {
                out.write(path + System.lineSeparator());
            }
        }
    }
    /**
     * Метод - возвращает список файлов.
     * @return  список файлов.
     */

    public List<Path> getList() {
        return this.result;
    }

    public static void main(String[] args) throws IOException {
        Finder find = new Finder(args);
        find.search();
        find.write();
    }
}
