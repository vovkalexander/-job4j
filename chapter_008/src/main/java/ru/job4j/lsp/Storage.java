package ru.job4j.lsp;

import java.text.ParseException;

public interface Storage {
    boolean addFood(Food food) throws ParseException;
}
