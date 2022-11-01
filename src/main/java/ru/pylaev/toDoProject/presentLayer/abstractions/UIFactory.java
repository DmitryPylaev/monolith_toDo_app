package ru.pylaev.toDoProject.presentLayer.abstractions;

public interface UIFactory {
    CustomPrinter getPrinter();
    ControllerInterface getController();
}
