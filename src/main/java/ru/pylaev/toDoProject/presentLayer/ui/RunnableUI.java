package ru.pylaev.toDoProject.presentLayer.ui;

import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUiFactory;

public class RunnableUI extends BaseUI implements Runnable {
    private final IRunnableController controller;
    public boolean active = true;

    public RunnableUI(RunnableUiFactory factory) {
        super(factory.getView(), factory.getUiStateModel(), factory.getRespondControllerLogic());
        this.controller = factory.getController();
        uiStateModel.addObserver(controller);
    }

    @Override
    public final void run() {
        view.show();
        while (active) controller.processUserInput(uiStateModel);
    }
}
