package ru.pylaev.toDoProject.presentLayer.controller.controllerLogic;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;

import java.util.function.BiConsumer;

@Component("mainControllerLogic")
public class MainRespondLogic implements BiConsumer<String, UiStateModel> {
    public void accept(String userInput, UiStateModel uiStateModel) {
        if (!UiStateService.checkInputBeforeContinue(userInput, uiStateModel)) {
            UiStateService.getEmptyRespond(uiStateModel);
        } else {
            UiStateService.getFullRespond(userInput, uiStateModel);
        }
    }
}
