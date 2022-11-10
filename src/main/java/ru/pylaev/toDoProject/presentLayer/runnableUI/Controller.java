package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IUserInputProcess;
import ru.pylaev.toDoProject.presentLayer.abstractions.Observable;
import ru.pylaev.toDoProject.presentLayer.abstractions.Observer;

import java.util.List;

public record Controller(InputGetter inputGetter,
                         IUserInputProcess controllerLogic) implements IController, Observable {
    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        controllerLogic.processUserInput(inputGetter.getNotEmptyInput(), uiStateModel);
    }

    @Override
    public void addObserver(Observer observer) {
        throw new UnsupportedOperationException("Добавить подписчиков пока нельзя");
    }

    @Override
    public void notifyObservers(List<Task> tasks) {
        throw new UnsupportedOperationException("Нет подписчиков");
    }
}
