package ru.pylaev.toDoProject.presentLayer.controller.runnable;

import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.factories.console.IConsoleUiFactory;

import java.util.ArrayList;
import java.util.List;

public class ConsoleController extends BaseRunnableController {
    public ConsoleController(IConsoleUiFactory factory) {
        super(factory);
    }

    @Override
    public void update(String message, List<Task> tasks) {
        String MAIN_COLOR = "\u001b[36m";
        String ALERT_COLOR = "\u001b[33m";
        String style = (tasks == null || tasks.size() < 1) ? ALERT_COLOR : MAIN_COLOR;
        viewHandler.update(style + "*******************************************************", new ArrayList<>());
    }
}
