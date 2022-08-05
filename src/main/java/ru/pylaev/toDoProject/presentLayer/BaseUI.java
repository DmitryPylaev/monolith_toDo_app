package ru.pylaev.toDoProject.presentLayer;

import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.presentLayer.view.View;

public abstract class BaseUI {
    protected View view;
    protected UiState uiState;

    public BaseUI(UiState uiState, View view) {
        this.uiState = uiState;
        this.view = view;
    }
}
