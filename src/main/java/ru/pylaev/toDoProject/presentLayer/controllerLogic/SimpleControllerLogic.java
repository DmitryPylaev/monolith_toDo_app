package ru.pylaev.toDoProject.presentLayer.controllerLogic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;
import ru.pylaev.toDoProject.presentLayer.abstractions.IUserInputProcess;

@Component
@Primary
public class SimpleControllerLogic implements IUserInputProcess {
    @Override
    public void processUserInput(String userInput, UiStateModel uiStateModel) {
        if (!UiStateService.checkInputBeforeContinue(userInput, uiStateModel)) {
            UiStateService.getEmptyRespond(uiStateModel);
        } else {
            UiStateService.getFullRespond(userInput, uiStateModel);
        }
    }
}
