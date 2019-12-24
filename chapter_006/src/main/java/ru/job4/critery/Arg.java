package ru.job4.critery;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Arg.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public  class Arg {
    /**
     * Поле - хранит карту значений принятых аргументов.
     */
    private   Map<String, String> map = new HashMap<>();
    /**
     * Поле - хранит объект сканер для ввода плдьзователя.
     */
    private Scanner in = new Scanner(System.in);
    /**
     * Конструктор  для активации полей
     * @param args массив аргументов командной строки.
     */
    public Arg(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                map.put("direct", args[++i]);
            }
            if (args[i].equals("-n")) {
                map.put("name", args[++i]);
            }
            if (args[i].equals("-m")) {
                map.put("mask", args[++i]);
            }
            if (args[i].equals("-f")) {
                map.put("fullname", args[++i]);
            }
            if (args[i].equals("-r")) {
                map.put("regex", args[++i]);
            }
            if (args[i].equals("-o")) {
                map.put("output", args[++i]);
            }
        }
    }
    /**
     * Метод возвращает карту значений аргументов .
     * @return карта значений.
     */
    public Map<String, String> getMap() {
        return  this.map;
    }
    /**
     * Метод - выводит меню выбора пользователю.
     */
    private void display() {
        StringBuilder build = new StringBuilder();
        build.append("Name:")
                .append("SEARCH BY CATEGORY")
                .append(System.lineSeparator())
                .append("Keys:")
                .append(System.lineSeparator())
                .append("  -d - start directory ")
                .append(System.lineSeparator())
                .append("  -n - file name, mask or regular expression")
                .append(System.lineSeparator())
                .append("  -o - directory of result of record to file ")
                .append(System.lineSeparator())
                .append("Category option:")
                .append(System.lineSeparator())
                .append("  -f - full name of file")
                .append(System.lineSeparator())
                .append("  -m - mask of file")
                .append(System.lineSeparator())
                .append("  -f - regular expression of file")

                .toString();
        System.out.println(build);

    }
    /**
     * Метод - устанавливает имя файла после выбора категории пользователя.
     */
    public void chooseCategory() {
        display();
        String scan;
            do {
                scan = in.next();
                if (scan.equals("-f")) {
                    map.put("name", map.get("fullname"));
                    break;
                }
                if (scan.equals("-m")) {
                    map.put("name", map.get("mask"));
                    break;
                }
                if (scan.equals("-r")) {
                    map.put("name", map.get("regex"));
                    break;
                } else {
                    System.out.println("please choose correct category or put finish");
                }
                System.out.println("Choose category: -f, -m, -r.");
            }  while (in.hasNext() && !scan .equals("finish"));


    }
}
