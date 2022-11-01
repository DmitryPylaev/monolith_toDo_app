package ru.pylaev.toDoProject.presentLayer.runnableUI.console;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.abstractions.ControllerLogicInterface;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;
import ru.pylaev.toDoProject.presentLayer.abstractions.CustomPrinter;
import ru.pylaev.toDoProject.presentLayer.runnableUI.SimplePrinter;
import ru.pylaev.toDoProject.presentLayer.abstractions.UIFactory;

@Component
public record ConsoleUIFactory(ConsoleInputGetter inputGetter, ControllerLogicInterface controllerLogic) implements UIFactory {
    @Override
    public CustomPrinter getPrinter() {
        return new SimplePrinter(System.out::println);
    }

    @Override
    public ControllerInterface getController() {
        return new CustomController(inputGetter, controllerLogic);
    }
}
