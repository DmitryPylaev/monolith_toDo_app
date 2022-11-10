package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUIFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.Controller;
import ru.pylaev.toDoProject.presentLayer.ui.PlainUiFactory;

import java.util.function.Consumer;

@Component
public record TelegramUIFactory(PlainUiFactory plainUiFactory, TelegramBot bot) implements RunnableUIFactory {
    @Override
    public Consumer<String> getPrinter() {
        return bot::send;
    }

    @Override
    public IController getController() {
        return new Controller(new TelegramInputGetter(bot), plainUiFactory().getView());
    }

    public PlainUiFactory getSimpleUiFactory() {
        return plainUiFactory;
    }
}
