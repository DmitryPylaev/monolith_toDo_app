package ru.pylaev.toDoProject.presentLayer.abstractions;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;

public interface IController extends Observer {
    void processUserInput(UiStateModel uiStateModel);
}
