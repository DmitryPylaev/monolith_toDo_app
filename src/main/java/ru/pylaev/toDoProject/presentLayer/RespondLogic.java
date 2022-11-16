package ru.pylaev.toDoProject.presentLayer;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRespondLogic;

@Component("mainControllerLogic")
public class RespondLogic implements IRespondLogic {
    public void getRespond(String userInput, UiStateModel uiStateModel) {
        if (!UiStateService.checkInputBeforeContinue(userInput, uiStateModel)) {
            UiStateService.getEmptyRespond(uiStateModel);
        } else {
            UiStateService.getFullRespond(userInput, uiStateModel);
        }
    }
}
