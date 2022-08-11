package ru.pylaev.toDoProject.presentLayer.runnableUi;

import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;
import ru.pylaev.toDoProject.presentLayer.BaseUI;
import ru.pylaev.toDoProject.presentLayer.view.View;

public abstract class BaseRunnableUI extends BaseUI implements Runnable {
    public BaseRunnableUI(UiState uiState, View view) {
        super(uiState, view);
    }

    @Override
    public final void run() {
        this.show();
        while (true) {
            String[] tasks = UiStateService.processUserInput(get(), uiState);
            String message = uiState.getStep().toString();
            view.update(message, tasks);
            show();
        }
    }

    public abstract void show();

    public abstract String get();


}
