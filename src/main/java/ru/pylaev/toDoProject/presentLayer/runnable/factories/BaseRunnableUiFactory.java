package ru.pylaev.toDoProject.presentLayer.runnable.factories;

import lombok.Getter;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.Controller;
import ru.pylaev.toDoProject.presentLayer.runnable.view.View;

public abstract class BaseRunnableUiFactory {
    @Getter protected final View view;
    @Getter protected final Controller controller;

    public BaseRunnableUiFactory(View view, Controller controller, UiStateModel uiStateModel) {
        this.view = view;
        this.controller = controller;
        uiStateModel.addObserver(this.view);
    }
}
