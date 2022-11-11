package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;

import java.util.List;

public class SimpleController implements IController {
    private final InputGetter inputGetter;
    private final IControllerLogic respondControllerLogic;

    public SimpleController(InputGetter inputGetter, IControllerLogic respondControllerLogic) {
        this.inputGetter = inputGetter;
        this.respondControllerLogic = respondControllerLogic;
    }

    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        respondControllerLogic.getRespond(inputGetter.getNotEmptyInput(), uiStateModel);
    }

    @Override
    public void update(String message, List<Task> tasks) {
//        throw new UnsupportedOperationException("Этот контроллер пока не умеет управлять представлением");
    }
}
