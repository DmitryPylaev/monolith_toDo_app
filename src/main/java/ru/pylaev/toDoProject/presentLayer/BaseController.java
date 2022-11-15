package ru.pylaev.toDoProject.presentLayer;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.IBaseControllerFactory;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.Observer;

import java.util.List;

public abstract class BaseController implements Observer {
    protected View view;
    protected UiStateModel uiStateModel;
    protected IControllerLogic respondControllerLogic;

    public BaseController(IBaseControllerFactory factory) {
        this.view = factory.getView();
        this.uiStateModel = factory.getUiStateModel();
        this.respondControllerLogic = factory.getRespondControllerLogic();
        uiStateModel.addObserver(view);
        uiStateModel.addObserver(this);
    }

    @Override
    public void update(String message, List<Task> tasks) {
//        throw new UnsupportedOperationException("Этот контроллер пока не умеет управлять представлением");
    }
}
