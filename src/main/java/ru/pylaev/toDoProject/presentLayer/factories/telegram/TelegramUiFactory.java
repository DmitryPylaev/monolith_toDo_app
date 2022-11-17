package ru.pylaev.toDoProject.presentLayer.factories.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.controller.controllerLogic.ExeptGraphLogic;
import ru.pylaev.toDoProject.presentLayer.factories.BaseUiFactory;
import ru.pylaev.toDoProject.presentLayer.view.TelegramBotView;
import ru.pylaev.toDoProject.presentLayer.view.UniversalViewHandler;

import java.util.function.BiConsumer;

@Component
public class TelegramUiFactory extends BaseUiFactory implements ITelegramUiFactory {
    @Autowired
    public TelegramUiFactory(UniversalViewHandler viewHandler,
                             UiStateModel uiStateModel,
                             BiConsumer<String, UiStateModel> rendControllerLogic,
                             ExeptGraphLogic graphLogic,
                             TelegramBotView bot) {
        super(viewHandler, uiStateModel, rendControllerLogic, graphLogic);
        viewHandler.setRunnableUi(bot);
    }
}
