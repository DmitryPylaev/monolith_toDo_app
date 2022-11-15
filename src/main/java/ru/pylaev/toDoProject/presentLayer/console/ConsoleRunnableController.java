package ru.pylaev.toDoProject.presentLayer.console;

import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;
import ru.pylaev.toDoProject.presentLayer.BaseRunnableController;

import java.util.List;

public class ConsoleRunnableController extends BaseRunnableController implements IRunnableController {
    public final static String MAIN_COLOR = "\u001b[36m";
    public final static String ALERT_COLOR = "\u001b[33m";

    public ConsoleRunnableController(IRunnableControllerFactory factory) {
        super(factory);
    }

    @Override
    public void update(String message, List<Task> tasks) {
        String style = (tasks == null || tasks.size() < 1) ? ALERT_COLOR : MAIN_COLOR;
        System.out.println(style + "*******************************************************");
    }
}
