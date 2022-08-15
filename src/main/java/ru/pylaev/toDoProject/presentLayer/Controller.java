package ru.pylaev.toDoProject.presentLayer;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Component
public abstract class Controller {
    protected View view;
    protected UiStateModel uiStateModel;

    public Controller(View view, UiStateModel uiStateModel) {
        this.view = view;
        this.uiStateModel = uiStateModel;
        uiStateModel.addObserver(view);
    }

    public void processingRequest(String input) {
        String[] tasks = UiStateService.processUserInput(input, uiStateModel);
        uiStateModel.notifyObservers(tasks);
    }
}
