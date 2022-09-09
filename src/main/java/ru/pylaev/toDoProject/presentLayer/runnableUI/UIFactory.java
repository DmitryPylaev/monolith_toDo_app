package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.presentLayer.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.CustomPrinter;

public interface UIFactory {
    CustomPrinter getPrinter();
    ControllerInterface getController();
}
