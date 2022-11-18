package ru.pylaev.toDoProject.presentLayer.runnable.controller;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.Controller;
import ru.pylaev.toDoProject.presentLayer.runnable.view.TelegramView;

import java.util.List;
import java.util.function.BiConsumer;

public class TelegramController extends Controller {
    private final TelegramView view;

    public TelegramController(TelegramView view,
                              UiStateModel uiStateModel,
                              BiConsumer<String, UiStateModel> respondLogic) {
        super(uiStateModel, respondLogic);
        this.view = view;
    }

    @Override
    public void update(String message, List<Task> tasks) {
        //        throw new UnsupportedOperationException("Этот контроллер пока не умеет управлять представлением");
    }
}
