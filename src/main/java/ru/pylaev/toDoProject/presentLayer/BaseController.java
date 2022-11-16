package ru.pylaev.toDoProject.presentLayer;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.IBaseControllerFactory;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRespondLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.Observer;

import java.util.List;

public abstract class BaseController implements Observer {
    protected ViewHandler viewHandler;
    protected UiStateModel uiStateModel;
    protected IRespondLogic respondControllerLogic;

    public BaseController(IBaseControllerFactory factory) {
        this.viewHandler = factory.getViewHandler();
        this.uiStateModel = factory.getUiStateModel();
        this.respondControllerLogic = factory.getRespondControllerLogic();
        uiStateModel.addObserver(viewHandler);
        uiStateModel.addObserver(this);
    }

    @Override
    public void update(String message, List<Task> tasks) {
//        throw new UnsupportedOperationException("Этот контроллер пока не умеет управлять представлением");
    }
}
