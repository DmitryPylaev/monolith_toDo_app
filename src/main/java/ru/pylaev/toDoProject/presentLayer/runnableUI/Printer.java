package ru.pylaev.toDoProject.presentLayer.runnableUI;

import java.util.function.Consumer;

public record Printer(Consumer<String> consumer) {
    public void display(String content) {
        consumer.accept(content);
    }
}
