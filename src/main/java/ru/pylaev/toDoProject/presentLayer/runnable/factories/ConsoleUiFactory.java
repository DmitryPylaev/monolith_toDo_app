package ru.pylaev.toDoProject.presentLayer.runnable.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.runnable.controller.ConsoleController;
import ru.pylaev.toDoProject.presentLayer.runnable.view.ConsoleView;

import java.util.function.BiConsumer;

@Component
public class ConsoleUiFactory extends BaseRunnableUiFactory {
    @Autowired
    public ConsoleUiFactory(ConsoleView view, UiStateModel uiStateModel, BiConsumer<String, UiStateModel> respondLogic) {
        super(view, new ConsoleController(view, uiStateModel, respondLogic), uiStateModel);
    }
}
