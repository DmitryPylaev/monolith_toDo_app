package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.presentLayer.view.View;

public interface UIFactory {
    CustomPrinter getPrinter();
    ControllerInterface getController(View view);
}
