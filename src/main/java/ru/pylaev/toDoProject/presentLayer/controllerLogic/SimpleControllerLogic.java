package ru.pylaev.toDoProject.presentLayer.controllerLogic;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;

public class SimpleControllerLogic {
    public static void getRespond(String userInput, UiStateModel uiStateModel) {
        if (!UiStateService.checkInputBeforeContinue(userInput, uiStateModel)) {
            UiStateService.getEmptyRespond(uiStateModel);
        } else {
            UiStateService.getFullRespond(userInput, uiStateModel);
        }
    }
}
