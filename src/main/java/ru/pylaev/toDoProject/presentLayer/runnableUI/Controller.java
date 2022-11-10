package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.controllerLogic.SimpleControllerLogic;

import java.util.List;

public record Controller(InputGetter inputGetter, View view) implements IController {
    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        SimpleControllerLogic.getRespond(inputGetter.getNotEmptyInput(), uiStateModel);
    }

    @Override
    public void update(String message, List<Task> tasks) {
//        throw new UnsupportedOperationException("Контроллер Runnable пока не умеет управлять представлением");
    }
}
