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
    Arg arg;
    /**
     * Поле - хранит начальный путь файла поиска.
     */
    String setup;
    /**
     * Поле - список файлов результа поиска.
     */
    List<String> list = new ArrayList<>();
    /**
     * Конструктор  для активации полей
     * @param args массив аргументов командной строки.
     */
    public MyFileVisitor(String[] args) throws IOException {
        arg = new Arg(args);
        setup = arg.directory();
        arg.chooseCategory();
    }
    /**
     * Метод - возвращает список файлов после выбронной категории пользователя и записывает в файл.
     * @param  path - начальный путь файла поиска
     * @param  attribs - тип атрибута файла no указанному пути.
     * @return   список файлов результата.
     */
    public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) throws IOException {
        String stg;
        if ((stg = path.toString()).contains(arg.getName())) {
            list.add(stg);
        } else {
            if (Pattern.compile(arg.getName()).matcher(stg).find()) {
                list.add(stg);
            }
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(arg.getOutput()))) {
            for (String string : list) {
                out.write(string + System.lineSeparator());
            }
        }
        return FileVisitResult.CONTINUE;
    }
}
