package ru.pylaev.toDoProject.presentLayer.abstractions;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;

public interface IUserInputProcess {
    void processUserInput(String userInput, UiStateModel uiStateModel);
}
