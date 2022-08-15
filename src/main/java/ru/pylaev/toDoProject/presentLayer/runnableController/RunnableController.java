package ru.pylaev.toDoProject.presentLayer.runnableController;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.Controller;
import ru.pylaev.toDoProject.presentLayer.view.View;

public abstract class RunnableController extends Controller implements Runnable {
    public RunnableController(View view, UiStateModel uiStateModel) {
        super(view, uiStateModel);
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
