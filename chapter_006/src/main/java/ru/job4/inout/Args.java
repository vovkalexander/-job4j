package ru.job4.inout;

public class Args {
    /**
     * Поле - хранит путь начального файла для архивации.
     */
    private String directory;
    /**
     * Поле - хранит исключающие расширение файла.
     */
    private String exclude;
    /**
     * Поле - хранит путь расположение файла после архивации .
     */
    private String output;
    /**
     * Конструктор  для активации полей
     * @param args массив аргументов командной строки.
     */
    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                this.directory =  args[++i];
            }
            if (args[i].equals("-e")) {
                this.exclude = args[++i];
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
     * Метод возвращает файл с исключающем расширением .
     * @return файл с исключающем расширением
     */
    public String exclude() {
        return this.exclude;
    }
    /**
     * Метод возвращает путь расположение файла после архивации .
     * @return путь расположение файла после архивации
     */
    public String output() {
        return this.output;
    }
    }


