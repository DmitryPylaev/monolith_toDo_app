package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.CustomPrinter;
import ru.pylaev.toDoProject.presentLayer.runnableUI.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;
import ru.pylaev.toDoProject.presentLayer.runnableUI.SimplePrinter;
import ru.pylaev.toDoProject.presentLayer.runnableUI.UIFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.console.ConsoleInputGetter;

@Component
public record TelegramUIFactory(ConsoleInputGetter inputGetter, TelegramBot bot) implements UIFactory {
    @Override
    public CustomPrinter getPrinter() {
        return new SimplePrinter(bot::send);
    }

    @Override
    public ControllerInterface getController() {
        return new CustomController(new TelegramInputGetter(bot));
    }
}
