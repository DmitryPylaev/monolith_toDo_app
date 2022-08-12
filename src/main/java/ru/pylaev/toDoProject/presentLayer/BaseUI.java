package ru.pylaev.toDoProject.presentLayer;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Component
public abstract class BaseUI {
    protected View view;
    protected UiState uiState;

    public BaseUI(View view, UiState uiState) {
        this.view = view;
        this.uiState = uiState;
    }

    public void processingRequest(String input) {
        String[] tasks = UiStateService.processUserInput(input, uiState);
        String message = uiState.getStep().toString();
        view.update(message, tasks);
    }
}
