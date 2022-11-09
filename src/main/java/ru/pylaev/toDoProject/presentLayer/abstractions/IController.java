package ru.pylaev.toDoProject.presentLayer.abstractions;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;

public interface IController {
    void processUserInput(UiStateModel uiStateModel);
}
