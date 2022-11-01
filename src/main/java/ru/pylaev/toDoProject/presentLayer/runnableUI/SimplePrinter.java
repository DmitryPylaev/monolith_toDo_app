package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.presentLayer.abstractions.CustomPrinter;

import java.util.function.Consumer;

public record SimplePrinter(Consumer<String> consumer) implements CustomPrinter {
    public void display(String content) {
        consumer.accept(content);
    }
}
