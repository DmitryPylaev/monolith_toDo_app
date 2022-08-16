package ru.pylaev.toDoProject.presentLayer.runnableController;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.UI;
import ru.pylaev.toDoProject.presentLayer.view.View;

public abstract class RunnableUI extends UI implements Runnable {
    private CustomController controller;

    public RunnableUI(View view, UiStateModel uiStateModel) {
        super(view, uiStateModel);
    }

    public void setController(CustomController controller) {
        this.controller = controller;
    }

    @Override
    public final void run() {
        view.show();
        while (true) {
            controller.processUserInput(uiStateModel);
        }
    }
}
