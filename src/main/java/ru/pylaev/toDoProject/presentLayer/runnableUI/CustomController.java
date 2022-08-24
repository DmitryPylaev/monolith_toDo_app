package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;

public class CustomController implements ControllerInterface {
    protected InputGetter inputGetter;

    public CustomController(InputGetter inputGetter) {
        this.inputGetter = inputGetter;
    }

    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        UiStateService.processUserInput(inputGetter.getInput(), uiStateModel);
    }
}
