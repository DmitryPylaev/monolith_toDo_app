package ru.pylaev.toDoProject.presentLayer.ui;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;

public abstract class PlainUI {
    protected View view;
    protected UiStateModel uiStateModel;

    public PlainUI(PlainUiFactory factory) {
        this.view = factory.getView();
        this.uiStateModel = factory.getUiStateModel();
    }
}
