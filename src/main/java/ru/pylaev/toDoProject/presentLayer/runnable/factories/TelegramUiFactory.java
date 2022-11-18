package ru.pylaev.toDoProject.presentLayer.runnable.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.runnable.controller.TelegramController;
import ru.pylaev.toDoProject.presentLayer.runnable.view.TelegramView;

import java.util.function.BiConsumer;

@Component
public class TelegramUiFactory extends BaseRunnableUiFactory {
    @Autowired
    public TelegramUiFactory(TelegramView view, UiStateModel uiStateModel, BiConsumer<String, UiStateModel> respondLogic) {
        super(view, new TelegramController(view, uiStateModel, respondLogic), uiStateModel);
    }
}
