package ru.pylaev.toDoProject.presentLayer.factories.telegram;

import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.controller.runnable.BaseRunnableController;

import java.util.List;

public class TelegramController extends BaseRunnableController {
    public TelegramController(ITelegramUiFactory factory) {
        super(factory);
    }

    @Override
    public void update(String message, List<Task> tasks) {

    }
}
