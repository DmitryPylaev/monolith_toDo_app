package ru.pylaev.toDoProject.presentLayer.runnableController;

import ru.pylaev.toDoProject.presentLayer.CustomPrinter;

import java.util.function.Consumer;

public class SimplePrinter implements CustomPrinter {
    protected Consumer<String> consumer;

    public SimplePrinter(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    public void display(String content) {
        consumer.accept(content);
    }
}
