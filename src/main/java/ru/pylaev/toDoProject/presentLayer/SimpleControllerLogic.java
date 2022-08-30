package ru.pylaev.toDoProject.presentLayer;

import ru.pylaev.toDoProject.businessLogicLayer.Respond;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;

public class SimpleControllerLogic {
    public void processUserInput(String userInput, UiStateModel uiStateModel) {
        Respond respond = getRespond(userInput, uiStateModel);
        uiStateModel.notifyObservers(respond);
    }

    private Respond getRespond(String userInput, UiStateModel uiStateModel) {
        if (!UiStateService.checkInputBeforeContinue(userInput, uiStateModel)) return UiStateService.getEmptyRespond();
        else return UiStateService.getFullRespond(userInput, uiStateModel);
    }
}
