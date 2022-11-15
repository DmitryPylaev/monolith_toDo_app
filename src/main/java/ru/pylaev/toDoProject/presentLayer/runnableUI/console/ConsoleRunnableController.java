package ru.pylaev.toDoProject.presentLayer.runnableUI.console;

import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;
import ru.pylaev.toDoProject.presentLayer.runnableUI.InputGetter;
import ru.pylaev.toDoProject.presentLayer.runnableUI.SimpleRunnableController;

import java.util.List;

public class ConsoleRunnableController extends SimpleRunnableController implements IRunnableController {
    public final static String MAIN_COLOR = "\u001b[36m";
    public final static String ALERT_COLOR = "\u001b[33m";

    public ConsoleRunnableController(InputGetter inputGetter, IControllerLogic respondControllerLogic) {
        super(inputGetter, respondControllerLogic);
    }

    @Override
    public void update(String message, List<Task> tasks) {
        String style = (tasks == null || tasks.size() < 1) ? ALERT_COLOR : MAIN_COLOR;
        System.out.println(style + "*******************************************************");
    }
}
