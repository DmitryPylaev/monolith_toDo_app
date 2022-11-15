package ru.pylaev.toDoProject.presentLayer.abstractions;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;

public interface RunnableUiFactory {
    IRunnableController getController();
    View getView();
    UiStateModel getUiStateModel();
    IControllerLogic getRespondControllerLogic();
}
