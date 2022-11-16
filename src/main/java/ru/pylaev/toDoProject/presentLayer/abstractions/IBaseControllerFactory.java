package ru.pylaev.toDoProject.presentLayer.abstractions;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.ViewHandler;

public interface IBaseControllerFactory {
    ViewHandler getViewHandler();
    UiStateModel getUiStateModel();
    IRespondLogic getRespondControllerLogic();
}
