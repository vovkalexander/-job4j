package ru.job4.InOut;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
/**
 * Config.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Config {

    /**
     * Поле - хранит путь к файлу.
     */
    private final String path;
    /**
     * Поле - хранит хеш таблицу запесей в файле.
     */
    private final Map<String, String> values = new HashMap<String, String>();
    /**
     * Конструктор для активации пути к файлу.
     * @param path  путь к файлу.
     */
    public Config(String path) {
        this.path = path;
    }
    /**
     * Метод - загружает файл в хеш таблицу.
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String line = null;
            while((line = read.readLine()) != null) {
                String[] rst = line.split("=");
                if (rst.length == 2) {
                    for (int i = 0; i < rst.length; i+=2) {
                        values.put(rst[i],rst[i+1]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Метод - возвращает значение по ключу.
     * @param key - ключ хеш таблицы.
     * @return  value - значение.
     */
    public String value(String key)  throws ValueNotFoundException {
        if (values.get(key) == null) {
            throw new ValueNotFoundException("Don't impl this method yet!");
        }
        return values.get(key);
    }
    /**
     * Метод - возвращает хеш таблицу.
     * @return  Map - хеш таблица.
     */
    public Map<String,String> getMap() {
        return this.values;
    }
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
    public static void main(String[] args) {
        Config conf = new Config("C:\\projects\\student\\Vovk Alexander\\-job4j\\app.properties");
        System.out.println(conf);
        conf.load();
    }
}
