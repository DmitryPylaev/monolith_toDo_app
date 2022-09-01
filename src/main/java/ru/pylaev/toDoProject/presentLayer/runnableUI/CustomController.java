package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.Observable;
import ru.pylaev.toDoProject.businessLogicLayer.Respond;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.ControllerLogicInterface;
import ru.pylaev.toDoProject.presentLayer.Observer;

public class CustomController implements ControllerInterface, Observable {
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

    @Override
    public void addObserver(Observer observer) {}

    @Override
    public void notifyObservers(Respond respond) {}
}
