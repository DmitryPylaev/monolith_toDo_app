package ru.pylaev.toDoProject.presentLayer.abstractions;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;

public interface IControllerLogic {
    void getRespond(String userInput, UiStateModel uiStateModel);
}
