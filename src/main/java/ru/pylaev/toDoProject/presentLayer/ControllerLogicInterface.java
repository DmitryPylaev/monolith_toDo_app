package ru.pylaev.toDoProject.presentLayer;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;

public interface ControllerLogicInterface {
    void processUserInput(String userInput, UiStateModel uiStateModel);
}
