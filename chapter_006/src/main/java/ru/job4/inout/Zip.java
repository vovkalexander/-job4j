package ru.job4.inout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * Zip.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Zip {
    /**
     * Поле - хранит ссылку класса Args.
     */
   private Args arg;
    /**
     * Конструктор для активации объекта класса Args.
     * @param args массив аргументов командной строки.
     */

    public Zip(String[] args) {
        arg = new Args(args);
    }
    /**
     * Метод - возвращает список файлов без конкретного расширения.
     * @param root - путь каталога файлов.
     * @param ext - расширение файла.
     * @return  список файлов без заданного расширения.
     */

    public List<File> seekBy(String root, String ext) {
        List<File> list = new LinkedList<>();
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(root));
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                for (File subFile : file.listFiles()) {
                    queue.add(subFile);
                }
            }
            if (file.isFile() && !file.getName().endsWith(ext)) {
                list.add(file);
            }
        }
        return list;
    }
    /**
     * Метод - архивирует проект.
     * @param source - список файлов без заданного расширения.
     * @param  target- путь хранения архива.
     */

    public void pack(List<File> source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(target))) {
            for (File file : source) {
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.putNextEntry(new ZipEntry(file.getPath()));
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Args getArg() {
        return arg;
    }

    public static void main(String[] args) {
        Zip zip = new Zip(args);
        List<File> list = zip.seekBy(zip.arg.directory(), zip.arg.exclude());
        zip.pack(list, new File(zip.arg.output()));
    }
}

