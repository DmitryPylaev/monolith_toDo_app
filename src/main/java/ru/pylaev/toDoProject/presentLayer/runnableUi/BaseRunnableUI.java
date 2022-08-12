package ru.pylaev.toDoProject.presentLayer.runnableUi;

import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.presentLayer.BaseUI;
import ru.pylaev.toDoProject.presentLayer.view.View;

public abstract class BaseRunnableUI extends BaseUI implements Runnable {
    public BaseRunnableUI(UiState uiState, View view) {
        super(uiState, view);
    }
    protected CustomPrinter printer;

    @Override
    public final void run() {
        printer.display(view.show());
        while (true) {
            processRequest();
            printer.display(view.show());
        }
    }
}
