package ru.job4.inout;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Search.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Search {
    /**
     * Метод - возвращает список файлов с конкретным расширением.
     * @param parent - путь каталога файлов.
     * @param exts - список расширения файлов.
     * @return  список файлов с заданным расширением.
     */
    List<File> files(String parent, List<String> exts) {
        List<File> list = new LinkedList<>();
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(parent));
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                for (File subFile : file.listFiles()) {
                    queue.add(subFile);
                }
            }
            for (String extension : exts) {
                if (file.isFile() && extension.contains(file.getName().substring(file.getName().lastIndexOf(".") + 1))) {
                    list.add(file);
                }
            }
        }
        return list;
    }
}

