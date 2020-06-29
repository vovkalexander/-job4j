package ru.job4j.cache;
import java.io.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
/**
 * Cache.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleCache extends Cache {
    /**
     * Field - stores map of value.
     */
    private Map<String, SoftReference<String>> cacheMap = new HashMap<>();
    /**
     * Field - path to file.
     */
    private String path;
    /**
     * Field - Constructor for activation  field.
     */

    public SimpleCache(String path) {
        this.path = path;
    }

    @Override
    public String getStuff(String filename) {
        String text = "";
        if (cacheMap.containsKey(filename))  {
            text = cacheMap.get(filename).get();
        }
        if (text == null || text.length() == 0 || !cacheMap.containsKey(filename)) {
            text = readFile(filename);
            cacheMap.put(filename, new SoftReference<>(text));
        }
        return text;
    }
    /**
     * Method finds file and reads date of it.
     * @param filename - name of file.
     * return value of file or empty string.
     */

    private String readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(
                new File(path, filename)))) {
            String record;
            StringBuilder build = new StringBuilder();
            while ((record = reader.readLine()) != null) {
                build.append(record).append(System.lineSeparator());
            }
            return build.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * Method returns map.
     * return map - field of class.
     */

    public Map<String, SoftReference<String>> getCache() {
        return cacheMap;
    }
}
