package ru.job4j.synch;
import java.nio.charset.Charset;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
/**
 * ParseFile.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ParseFile {
    /**
     * Field - stores link of object File.
     */
    private volatile File file;
    /**
     * The Method activates field file.
     * @param f - object of class File.
     */

    public synchronized void setFile(File f) {
        file = f;
    }
    /**
     * The Method returns object  class File.
     * @return  object of class File.
     */

    public synchronized File getFile() {
        return file;
    }
    /**
     * The Method reads data of  object File.
     * @return  content of  object File  .
     */

    public synchronized  String getContent() throws IOException {
        return Files
                .lines(Paths.get(file.getName()), Charset.defaultCharset())
                .collect(Collectors.joining(System.lineSeparator()));
    }
    /**
     * The Method reads data of  object File.
     * @return  content of  object File  with only basic english.
     */

    public synchronized String getContentWithoutUnicode() throws IOException {
        return Files
                .lines(Paths.get(file.getName()), Charset.forName("US-ASCII"))
                .collect(Collectors.joining(System.lineSeparator()));

    }
    /**
     * The Method records data to object File.
     * @param content of String.
     */

    public synchronized void saveContent(String content) throws IOException {
        Files.write(Paths.get(file.getName()), content.getBytes(Charset.defaultCharset()));
    }
}
