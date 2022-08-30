package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.SimpleControllerLogic;

public class CustomController implements ControllerInterface {
    protected InputGetter inputGetter;
    protected SimpleControllerLogic controllerLogic;

    public CustomController(InputGetter inputGetter, SimpleControllerLogic simpleControllerLogic) {
        this.inputGetter = inputGetter;
        this.controllerLogic = simpleControllerLogic;
    }

    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        controllerLogic.processUserInput(inputGetter.getInput(), uiStateModel);
    }
}
