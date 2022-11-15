package ru.pylaev.toDoProject.presentLayer.abstractions;

public interface IBaseControllerFactory {
    ru.pylaev.toDoProject.presentLayer.View getView();

    ru.pylaev.toDoProject.businessLogicLayer.UiStateModel getUiStateModel();

    ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic getRespondControllerLogic();
}
