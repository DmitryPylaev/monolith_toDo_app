package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.ControllerLogicInterface;

public class CustomController implements ControllerInterface {
    protected InputGetter inputGetter;
    protected ControllerLogicInterface controllerLogic;

    public CustomController(InputGetter inputGetter, ControllerLogicInterface controllerLogic) {
        this.inputGetter = inputGetter;
        this.controllerLogic = controllerLogic;
    }

    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        controllerLogic.processUserInput(inputGetter.getInput(), uiStateModel);
    }
}
