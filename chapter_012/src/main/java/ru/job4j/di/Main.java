package ru.job4j.di;

import org.checkerframework.checker.units.qual.C;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);
        StartUI ui = context.get(StartUI.class);
        ui.add("Otto");
        ui.add("Pupkin");
        ui.add("Juan");
        ui.print();
    }
}
