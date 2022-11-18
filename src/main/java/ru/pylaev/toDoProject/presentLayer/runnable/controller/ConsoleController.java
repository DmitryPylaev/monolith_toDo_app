package ru.pylaev.toDoProject.presentLayer.runnable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.Controller;
import ru.pylaev.toDoProject.presentLayer.runnable.view.View;
import ru.pylaev.toDoProject.presentLayer.runnable.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

@Component
public class ConsoleController extends Controller {
    private final View view;

    @Autowired
    public ConsoleController(ConsoleView view,
                             UiStateModel uiStateModel,
                             BiConsumer<String, UiStateModel> respondLogic) {
        super(uiStateModel, respondLogic);
        this.view = view;
    }

    @Override
    public void update(String message, List<Task> tasks) {
        String MAIN_COLOR = "\u001b[36m";
        String ALERT_COLOR = "\u001b[33m";
        String style = (tasks == null || tasks.size() < 1) ? ALERT_COLOR : MAIN_COLOR;
        view.update(style, new ArrayList<>());
    }
}
