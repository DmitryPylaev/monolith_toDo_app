package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.Respond;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;
import ru.pylaev.toDoProject.presentLayer.view.View;

public class CustomController implements ControllerInterface {
    protected InputGetter inputGetter;
    private View view;

    public CustomController(InputGetter inputGetter, View view) {
        this.inputGetter = inputGetter;
    }

    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        UiStateService.processUserInput(inputGetter.getInput(), uiStateModel);
    }

    @Override
    public void update(String message, Respond respond) {

    }
}
