package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.ControllerLogicInterface;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;
import ru.pylaev.toDoProject.presentLayer.CustomPrinter;
import ru.pylaev.toDoProject.presentLayer.runnableUI.SimplePrinter;
import ru.pylaev.toDoProject.presentLayer.runnableUI.UIFactory;

@Component
public record TelegramUIFactory(ControllerLogicInterface controllerLogic, TelegramBot bot) implements UIFactory {
    @Override
    public CustomPrinter getPrinter() {
        return new SimplePrinter(bot::send);
    }

    @Override
    public ControllerInterface getController() {
        return new CustomController(new TelegramInputGetter(bot), controllerLogic);
    }
}
