package ru.pylaev.toDoProject.presentLayer.abstractions;

import ru.pylaev.toDoProject.presentLayer.runnableUI.Printer;

public interface UIFactory {
    Printer getPrinter();
    IController getController();
}
