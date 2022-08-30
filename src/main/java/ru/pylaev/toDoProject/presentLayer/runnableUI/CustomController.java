package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.MainControllerLogic;

public class CustomController implements ControllerInterface {
    protected InputGetter inputGetter;
    protected MainControllerLogic controllerLogic;

    public CustomController(InputGetter inputGetter, MainControllerLogic mainControllerLogic) {
        this.inputGetter = inputGetter;
        this.controllerLogic = mainControllerLogic;
    }

    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        controllerLogic.processUserInput(inputGetter.getInput(), uiStateModel);
    }
}
