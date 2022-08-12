package ru.pylaev.toDoProject.presentLayer;

import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;
import ru.pylaev.toDoProject.presentLayer.view.View;

public abstract class BaseUI {
    protected View view;
    protected UiState uiState;

    protected BaseUI(UiState uiState, View view) {
        this.uiState = uiState;
        this.view = view;
    }

    public void processRequest() {
        String[] tasks = UiStateService.processUserInput(getInput(), uiState);
        String message = uiState.getStep().toString();
        view.set(message, tasks);
    }

    protected abstract String getInput();
}
