package ru.pylaev.toDoProject.presentLayer.runnableUI;

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
