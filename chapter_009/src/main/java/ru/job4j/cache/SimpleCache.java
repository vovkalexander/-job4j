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
        if (!cacheMap.containsKey(filename) || cacheMap.get(filename) == null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(
                    new File(path, filename)))) {
                String record;
                StringBuilder buid = new StringBuilder();
                while ((record = reader.readLine()) != null) {
                    buid.append(record).append(System.lineSeparator());
                }
                cacheMap.put(filename, new SoftReference<>(buid.toString()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cacheMap.get(filename).get();
    }
    /**
     * Method returns map.
     * return map - field of class.
     */

    public Map<String, SoftReference<String>> getCache() {
        return cacheMap;
    }
}
