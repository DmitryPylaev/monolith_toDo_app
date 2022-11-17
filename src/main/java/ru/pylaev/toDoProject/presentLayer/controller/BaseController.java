package ru.pylaev.toDoProject.presentLayer.controller;

import ru.pylaev.toDoProject.abstractions.Observer;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.factories.IBaseUiFactory;
import ru.pylaev.toDoProject.presentLayer.view.UniversalViewHandler;

import java.util.List;
import java.util.function.BiConsumer;

public abstract class BaseController implements Observer {
    protected UniversalViewHandler viewHandler;
    protected UiStateModel uiStateModel;
    protected BiConsumer<String, UiStateModel> respondLogic;
    protected BiConsumer<String, List<Task>> graphLogic;

    public BaseController(IBaseUiFactory factory) {
        this.viewHandler = factory.getViewHandler();
        this.uiStateModel = factory.getUiStateModel();
        this.respondLogic = factory.getRespondLogic();
        this.graphLogic = factory.getGraphLogic();
        uiStateModel.addObserver(viewHandler);
        uiStateModel.addObserver(this);
    }

    @Override
    public void update(String message, List<Task> tasks) {
        graphLogic.accept(message, tasks);
    }
}
