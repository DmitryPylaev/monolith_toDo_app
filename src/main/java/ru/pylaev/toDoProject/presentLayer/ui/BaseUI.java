package ru.pylaev.toDoProject.presentLayer.ui;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;

public abstract class BaseUI {
    protected View view;
    protected UiStateModel uiStateModel;

    public BaseUI(View view, UiStateModel uiStateModel) {
        this.view = view;
        this.uiStateModel = uiStateModel;
        uiStateModel.addObserver(view);
    }
}
