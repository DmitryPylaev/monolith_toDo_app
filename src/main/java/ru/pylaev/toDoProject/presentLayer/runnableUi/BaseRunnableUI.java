package ru.pylaev.toDoProject.presentLayer.runnableUi;

import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.presentLayer.BaseUI;
import ru.pylaev.toDoProject.presentLayer.view.View;

public abstract class BaseRunnableUI extends BaseUI implements Runnable {
    public BaseRunnableUI(UiState uiState, View view) {
        super(uiState, view);
    }

    @Override
    public final void run() {
        this.showStartView();
        while (true) {
            this.processUserInput();
        }
    }

    public abstract void showStartView();

    public abstract void processUserInput();
}
