package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.Observer;

public interface ControllerInterface extends Observer {
    void processUserInput(UiStateModel uiStateModel);
}
