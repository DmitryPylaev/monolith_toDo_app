package ru.pylaev.toDoProject.presentLayer.ui;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUIFactory;

public class RunnableUI extends BaseUI implements Runnable {
    private final IController controller;
    public boolean active = true;

    public RunnableUI(View view, UiStateModel uiStateModel, RunnableUIFactory factory) {
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
