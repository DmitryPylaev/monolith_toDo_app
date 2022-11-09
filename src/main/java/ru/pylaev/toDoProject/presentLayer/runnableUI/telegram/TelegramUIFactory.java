package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IUserInputProcess;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;
import ru.pylaev.toDoProject.presentLayer.runnableUI.Printer;
import ru.pylaev.toDoProject.presentLayer.abstractions.UIFactory;

@Component
public record TelegramUIFactory(IUserInputProcess controllerLogic, TelegramBot bot) implements UIFactory {
    @Override
    public Printer getPrinter() {
        return new Printer(bot::send);
    }

    @Override
    public IController getController() {
        return new CustomController(new TelegramInputGetter(bot), controllerLogic);
    }
}
