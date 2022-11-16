package ru.pylaev.toDoProject.presentLayer.runnableUi.console;

import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUi.BaseRunnableController;

import java.util.List;

public class ConsoleController extends BaseRunnableController {
    public final static String MAIN_COLOR = "\u001b[36m";
    public final static String ALERT_COLOR = "\u001b[33m";

    public ConsoleController(IRunnableControllerFactory factory) {
        super(factory);
    }

    @Override
    public void update(String message, List<Task> tasks) {
        String style = (tasks == null || tasks.size() < 1) ? ALERT_COLOR : MAIN_COLOR;
        System.out.println(style + "*******************************************************");
    }
}
