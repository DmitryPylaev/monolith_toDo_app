package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.presentLayer.ControllerInterface;

public interface UIFactory {
    CustomPrinter getPrinter();
    ControllerInterface getController();
}
