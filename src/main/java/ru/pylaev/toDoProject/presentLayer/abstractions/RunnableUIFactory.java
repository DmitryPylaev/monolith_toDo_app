package ru.pylaev.toDoProject.presentLayer.abstractions;

import java.util.function.Consumer;

public interface RunnableUIFactory {
    Consumer<String> getPrinter();
    IController getController();
}
