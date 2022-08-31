package ru.pylaev.toDoProject.presentLayer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;

@Component
@Primary
public class SimpleControllerLogic implements ControllerLogicInterface {
    @Override
    public void processUserInput(String userInput, UiStateModel uiStateModel) {
        UiStateService.processUserInput(userInput, uiStateModel);
    }
}
