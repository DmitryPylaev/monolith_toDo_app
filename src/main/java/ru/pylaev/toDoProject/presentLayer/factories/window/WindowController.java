package ru.pylaev.toDoProject.presentLayer.factories.window;

import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.controller.runnable.BaseRunnableController;

import java.util.List;

public class WindowController extends BaseRunnableController {
    public WindowController(IWindowUiFactory factory) {
        super(factory);
    }

    @Override
    public void update(String message, List<Task> tasks) {

    }
}
