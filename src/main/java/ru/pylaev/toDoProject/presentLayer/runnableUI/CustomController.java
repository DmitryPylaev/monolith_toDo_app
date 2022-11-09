package ru.pylaev.toDoProject.presentLayer.runnableUI;

import lombok.AllArgsConstructor;
import ru.pylaev.toDoProject.presentLayer.abstractions.Observable;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IUserInputProcess;
import ru.pylaev.toDoProject.presentLayer.abstractions.Observer;

import java.util.List;

@AllArgsConstructor
public record CustomController(InputGetter inputGetter,
                               IUserInputProcess controllerLogic) implements IController, Observable {
    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        controllerLogic.processUserInput(inputGetter.getInput(), uiStateModel);
    }

    @Override
    public void addObserver(Observer observer) {
    }

    @Override
    public void notifyObservers(List<Task> tasks) {
    }
}
