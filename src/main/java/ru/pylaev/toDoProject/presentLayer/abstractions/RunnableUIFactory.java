package ru.pylaev.toDoProject.presentLayer.abstractions;

import ru.pylaev.toDoProject.presentLayer.ui.PlainUiFactory;

import java.util.function.Consumer;

public interface RunnableUIFactory {
    Consumer<String> getPrinter();
    IController getController();
    PlainUiFactory getSimpleUiFactory();
}
