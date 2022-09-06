package ru.pylaev.toDoProject.presentLayer.runnableUI;

import lombok.AllArgsConstructor;
import ru.pylaev.toDoProject.businessLogicLayer.Observable;
import ru.pylaev.toDoProject.businessLogicLayer.Respond;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.ControllerLogicInterface;
import ru.pylaev.toDoProject.presentLayer.Observer;

@SuppressWarnings("ClassCanBeRecord")
@AllArgsConstructor
public class CustomController implements ControllerInterface, Observable {
    private final InputGetter inputGetter;
    private final ControllerLogicInterface controllerLogic;

    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        controllerLogic.processUserInput(inputGetter.getInput(), uiStateModel);
    }

    @Override
    public void addObserver(Observer observer) {}

    @Override
    public void notifyObservers(Respond respond) {}
}
