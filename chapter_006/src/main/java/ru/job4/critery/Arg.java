package ru.job4.critery;
import java.io.IOException;
import java.util.Scanner;
/**
 * Arg.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public  class Arg {
    /**
     * Поле - хранит путь начального файла для поиска.
     */
    private String directory;
    /**
     * Поле - хранит имя или маску или регулярное выражение файла.
     */
    private String name;
    /**
     * Поле - хранит  маску  файла.
     */
    private String mask;
    /**
     * Поле - хранит  полное имя  файла.
     */
    private String fullName;
    /**
     * Поле - хранит  регулярное выражение файла.
     */
    private String regex;
    /**
     * Поле - хранит путь файла записи результата.
     */
    private String output;
    /**
     * Поле - хранит объект сканер для ввода плдьзователя.
     */
    Scanner in = new Scanner(System.in);
    /**
     * Конструктор  для активации полей
     * @param args массив аргументов командной строки.
     */
    public Arg(String[] args ) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                this.directory = args[++i];
            }
            if (args[i].equals("-n")) {
                this.name = args[++i];
            }
            if (args[i].equals("-m")) {
                this.mask = args[++i];
            }
            if (args[i].equals("-f")) {
                this.fullName = args[++i];
            }
            if (args[i].equals("-r")) {
                this.regex = args[++i];
            }
            if (args[i].equals("-o")) {
                this.output = args[++i];
            }
        }
    }
    /**
     * Метод возвращает путь начального файла.
     * @return путь начального файла.
     */
    public String directory() {
        return this.directory;
    }
    /**
     * Метод возвращает  имя файла.
     * @return  имя файла.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Метод возвращает  маску файла.
     * @return  маска файла.
     */
    public String getMask() {
        return this.mask;
    }
    /**
     * Метод возвращает полное имя файла.
     * @return полное имя файла.
     */
    public String getFullName() {
        return this.fullName;
    }
    /**
     * Метод возвращает регулярное выражение файла.
     * @return регулярное выражение файла.
     */
    public String getRegex() {
        return this.regex;
    }
    /**
     * Метод возвращает путь файла рузульта поиска .
     * @return файл результата поиска.
     */
    public String getOutput() {
        return this.output;
    }
    /**
     * Метод устанавливает имя файла .
     * @param name имя файла.
     */
    public void setName (String name)  {
        this.name= name;

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
    public void chooseCategory() throws IOException {
        display();
        String scan;
        System.out.println("Choose category: -f, -m, -r.");
        while (in.hasNext()&& !(scan = in.next()).equals("finish")) {
            if (scan.equals("-f")) {
                this.setName(getFullName());
                break;
            }
            if (scan.equals("-m")) {
                this.setName(getMask());
                break;
            }
            if (scan.equals("-r")) {
                this.setName(getRegex());
                break;
            } else  {
                System.out.println("please choose correct category or put finish");
            }
        }

    }
    public static void main(String[] args) throws IOException {
        Arg arg = new Arg(args);
        arg.chooseCategory();
      System.out.println(System.getProperty("user.dir"));
    }
}