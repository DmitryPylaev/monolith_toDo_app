package ru.pylaev.toDoProject.presentLayer.runnable.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.runnable.controller.WindowController;
import ru.pylaev.toDoProject.presentLayer.runnable.view.WindowView;

import java.util.function.BiConsumer;

@Component
public class WindowUiFactory extends BaseRunnableUiFactory {
     @Autowired
    public WindowUiFactory(WindowView view, UiStateModel uiStateModel, BiConsumer<String, UiStateModel> respondLogic) {
        super(view, new WindowController(view, uiStateModel, respondLogic), uiStateModel);
    }
}
