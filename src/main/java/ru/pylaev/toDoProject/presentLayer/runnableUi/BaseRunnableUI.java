package ru.pylaev.toDoProject.presentLayer.runnableUi;

import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.presentLayer.BaseUI;
import ru.pylaev.toDoProject.presentLayer.view.View;

public abstract class BaseRunnableUI extends BaseUI implements Runnable {
    public BaseRunnableUI(View view, UiState uiState) {
        super(view, uiState);
    }

    @Override
    public final void run() {
        view.show();
        while (true) {
            processingRequest(getInput());
        }
    }

    protected abstract String getInput();
}
