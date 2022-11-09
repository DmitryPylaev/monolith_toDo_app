package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IUserInputProcess;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUIFactory;

import java.util.function.Consumer;

@Component
public record TelegramUIFactory(IUserInputProcess controllerLogic, TelegramBot bot) implements RunnableUIFactory {
    @Override
    public Consumer<String> getPrinter() {return bot::send;}

    @Override
    public IController getController() {
        return new CustomController(new TelegramInputGetter(bot), controllerLogic);
    }
}
