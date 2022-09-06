package ru.pylaev.toDoProject.presentLayer.runnableUI;

import java.util.function.Consumer;

public record SimplePrinter(Consumer<String> consumer) implements CustomPrinter {
    public void display(String content) {
        consumer.accept(content);
    }
}
