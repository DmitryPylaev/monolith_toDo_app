package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;

public class CustomController {
    protected InputGetter inputGetter;

    public CustomController(InputGetter inputGetter) {
        this.inputGetter = inputGetter;
    }

    public void processUserInput(UiStateModel uiStateModel) {
        UiStateService.processUserInput(inputGetter.getInput(), uiStateModel);
    }
}
