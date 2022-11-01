package ru.pylaev.toDoProject.presentLayer.runnableUI;

import lombok.AllArgsConstructor;
import ru.pylaev.toDoProject.presentLayer.abstractions.Observable;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.abstractions.ControllerLogicInterface;
import ru.pylaev.toDoProject.presentLayer.abstractions.Observer;

import java.util.List;

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
    public void notifyObservers(List<Task> tasks) {}
}
