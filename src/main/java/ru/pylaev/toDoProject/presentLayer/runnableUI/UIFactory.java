package ru.pylaev.toDoProject.presentLayer.runnableUI;

public interface UIFactory {
    CustomPrinter getPrinter();
    ControllerInterface getController();
}
