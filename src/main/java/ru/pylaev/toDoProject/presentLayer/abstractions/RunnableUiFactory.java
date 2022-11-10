package ru.pylaev.toDoProject.presentLayer.abstractions;

import ru.pylaev.toDoProject.presentLayer.ui.PlainUiFactory;

public interface RunnableUiFactory {
    IController getController();
    PlainUiFactory getPlainUiFactory();
}
