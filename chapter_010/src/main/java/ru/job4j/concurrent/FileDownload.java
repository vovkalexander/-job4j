package ru.job4j.concurrent;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
/**
 * FileDownload.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class FileDownload {
    /**
     * Field - stores String value.
     */
    private String file;
    /**
     * Field - stores int value.
     */
    private int speed;
    /**
     * Constructor for activation fields.
     */

    public FileDownload(String[] args) {
        this.file = args[0];
        this.speed = Integer.parseInt(args[1]);
    }
    /**
     * The method limits a speed of downloading.
     */

    public void download() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[1024];
            long begin = System.currentTimeMillis();
            long currentTime;
            int size = 0;
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                size += bytesRead;
                currentTime = System.currentTimeMillis() - begin;
                if (currentTime < 1000 && size >= (speed * 1024)) {
                    try {
                        Thread.sleep(1000 - (currentTime - begin));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileDownload download = new FileDownload(args);
        download.download();

    }
}


