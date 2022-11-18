package ru.pylaev.toDoProject.presentLayer.runnable;

import ru.pylaev.toDoProject.presentLayer.Controller;
import ru.pylaev.toDoProject.presentLayer.runnable.factories.BaseRunnableUiFactory;
import ru.pylaev.toDoProject.presentLayer.runnable.view.View;

public class RunnableHandler implements Runnable{
    public boolean active = true;
    private final View view;
    private final Controller controller;

    public RunnableHandler(BaseRunnableUiFactory factory) {
        this.view = factory.getView();
        this.controller = factory.getController();
    }

    @Override
    public final void run() {
        view.show();
        while (active) controller.processUserInput(view.getNotEmptyInput());
    }
}
