package ru.pylaev.toDoProject.presentLayer.factories;

public interface IBaseUiFactory {
    ru.pylaev.toDoProject.presentLayer.view.UniversalViewHandler getViewHandler();

    ru.pylaev.toDoProject.businessLogicLayer.UiStateModel getUiStateModel();

    java.util.function.BiConsumer<String, ru.pylaev.toDoProject.businessLogicLayer.UiStateModel> getRespondLogic();

    java.util.function.BiConsumer<String, java.util.List<ru.pylaev.toDoProject.dataAccessLayer.Task>> getGraphLogic();
}
