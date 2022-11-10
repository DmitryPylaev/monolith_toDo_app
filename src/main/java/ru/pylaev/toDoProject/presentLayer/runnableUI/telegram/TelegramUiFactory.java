package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUiFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.Controller;
import ru.pylaev.toDoProject.presentLayer.ui.PlainUiFactory;

@Component
public class TelegramUiFactory implements RunnableUiFactory {
    private final PlainUiFactory plainUiFactory;
    private final TelegramBot bot;

    @Autowired
    public TelegramUiFactory(PlainUiFactory plainUiFactory, TelegramBot bot) {
        this.plainUiFactory = plainUiFactory;
        this.bot = bot;
        plainUiFactory.getView().setPrinter(bot::send);
    }

    @Override
    public IController getController() {
        return new Controller(new TelegramInputGetter(bot), plainUiFactory.getView());
    }

    @Override
    public PlainUiFactory getPlainUiFactory() {
        return plainUiFactory;
    }
}
