package ru.pylaev.toDoProject.presentLayer.runnableUI;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.UI;
import ru.pylaev.toDoProject.presentLayer.view.View;

public abstract class RunnableUI extends UI implements Runnable {
    private final ControllerInterface controller;
    public boolean active = true;

    public RunnableUI(View view, UiStateModel uiStateModel, UIFactory factory) {
        super(view, uiStateModel);
        view.setPrinter(factory.getPrinter());
        controller = factory.getController();
    }

    @Override
    public final void run() {
        view.show();
        while (active) controller.processUserInput(uiStateModel);
    }
}
