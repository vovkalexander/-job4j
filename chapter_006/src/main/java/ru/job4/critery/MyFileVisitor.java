package ru.job4.critery;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/**
 * MyFileVisitor.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {
    /**
     * Поле - хранит ссылку класса Arg.
     */
    private  Arg arg;
    /**
     * Поле - список файлов результа поиска.
     */
    private List<String> list = new ArrayList<>();
    /**
     * Конструктор  для активации полей
     * @param args массив аргументов командной строки.
     */
    public MyFileVisitor(String[] args) throws IOException {
        arg = new Arg(args);
        arg.chooseCategory();
    }
    /**
     * Метод - возвращает путь начального файла поиска.
     * @return  начальный файл поиска.
     */
    public String getSetup() {
        return arg.getMap().get("direct");
    }
    /**
     * Метод - возвращает список файлов.
     * @return  список файлов.
     */
    public List<String> getList() {
        return this.list;
    }
    /**
     * Метод - возвращает список файлов после выбронной категории пользователя.
     * @param  path - начальный путь файла поиска
     * @param  attribs - тип атрибута файла no указанному пути.
     * @return   список файлов результата.
     */
    public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) throws IOException {
        String stg;
        if ((stg = path.toString()).contains(arg.getMap().get("name"))) {
            list.add(stg);
        } else {
            if (Pattern.compile(arg.getMap().get("name")).matcher(stg).find()) {
                list.add(stg);
            }
        }
        return FileVisitResult.CONTINUE;
    }
    /**
     * Метод - записывает список файлов в удаленный файл.
     */
    public void write() throws IOException  {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(arg.getMap().get("output")))) {
            for (String string : this.list) {
                out.write(string + System.lineSeparator());
            }
        }
    }
}
