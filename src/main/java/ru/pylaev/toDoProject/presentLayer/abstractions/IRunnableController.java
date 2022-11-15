package ru.pylaev.toDoProject.presentLayer.abstractions;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;

public interface IRunnableController extends Observer {
    void processUserInput(UiStateModel uiStateModel);
}
