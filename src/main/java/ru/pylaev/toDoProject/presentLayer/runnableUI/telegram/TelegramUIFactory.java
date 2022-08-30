package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.SimpleControllerLogic;
import ru.pylaev.toDoProject.presentLayer.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.runnableUI.*;
import ru.pylaev.toDoProject.presentLayer.runnableUI.console.ConsoleInputGetter;

@Component
public record TelegramUIFactory(ConsoleInputGetter inputGetter, TelegramBot bot) implements UIFactory {
    @Override
    public CustomPrinter getPrinter() {
        return new SimplePrinter(bot::send);
    }

    @Override
    public ControllerInterface getController() {
        return new CustomController(new TelegramInputGetter(bot), new SimpleControllerLogic());
    }
}
