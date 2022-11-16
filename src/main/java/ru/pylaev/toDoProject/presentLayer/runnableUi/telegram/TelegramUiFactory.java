package ru.pylaev.toDoProject.presentLayer.runnableUi.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.BaseUiFactory;
import ru.pylaev.toDoProject.presentLayer.ViewHandler;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRespondLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;

import java.util.function.Supplier;

@Component
public class TelegramUiFactory extends BaseUiFactory implements IRunnableControllerFactory {
    private final TelegramBotView bot;

    @Autowired
    public TelegramUiFactory(ViewHandler viewHandler, UiStateModel uiStateModel, IRespondLogic rendControllerLogic, TelegramBotView bot) {
        super(viewHandler, uiStateModel, rendControllerLogic);
        this.bot = bot;
        viewHandler.setPainter(bot::display);
    }

    @Override
    public Supplier<String> getRequestSupplier() {
        return bot::getNotEmptyInput;
    }
}
