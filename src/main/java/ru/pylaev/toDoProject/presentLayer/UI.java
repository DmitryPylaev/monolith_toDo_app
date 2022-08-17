package ru.pylaev.toDoProject.presentLayer;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.view.View;

public abstract class UI {
    protected View view;
    protected UiStateModel uiStateModel;

    public UI(View view, UiStateModel uiStateModel) {
        this.view = view;
        this.uiStateModel = uiStateModel;
        uiStateModel.addObserver(view);
    }
}
