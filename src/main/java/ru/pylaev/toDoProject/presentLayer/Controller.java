package ru.pylaev.toDoProject.presentLayer;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;

import java.util.List;
import java.util.function.BiConsumer;

public abstract class Controller implements Observer {
    protected UiStateModel uiStateModel;
    protected BiConsumer<String, UiStateModel> respondLogic;

    public Controller(UiStateModel uiStateModel,
                      BiConsumer<String, UiStateModel> respondLogic) {
        this.uiStateModel = uiStateModel;
        this.respondLogic = respondLogic;
        uiStateModel.addObserver(this);
    }

    public void processUserInput(String input) {
        respondLogic.accept(input, uiStateModel);
    }

    @Override
    public abstract void update(String message, List<Task> tasks);
}
