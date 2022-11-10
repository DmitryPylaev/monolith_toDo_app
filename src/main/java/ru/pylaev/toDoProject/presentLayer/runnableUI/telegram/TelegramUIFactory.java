package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUIFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.Controller;

import java.util.function.Consumer;

@Component
public record TelegramUIFactory(TelegramBot bot) implements RunnableUIFactory {
    @Override
    public Consumer<String> getPrinter() {
        return bot::send;
    }

    @Override
    public IController getController() {
        return new Controller(new TelegramInputGetter(bot));
    }
}
