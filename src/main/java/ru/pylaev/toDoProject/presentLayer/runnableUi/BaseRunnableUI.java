package ru.pylaev.toDoProject.presentLayer.runnableUi;

import ru.pylaev.toDoProject.businessLogicLayer.State;
import ru.pylaev.toDoProject.presentLayer.BaseUI;
import ru.pylaev.toDoProject.presentLayer.view.View;

public abstract class BaseRunnableUI extends BaseUI implements Runnable {
    public BaseRunnableUI(State state, View view) {
        super(state, view);
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
