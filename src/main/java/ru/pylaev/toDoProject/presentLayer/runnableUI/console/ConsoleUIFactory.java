package ru.pylaev.toDoProject.presentLayer.runnableUI.console;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IUserInputProcess;
import ru.pylaev.toDoProject.presentLayer.abstractions.UIFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;
import ru.pylaev.toDoProject.presentLayer.runnableUI.Printer;

@Component
public record ConsoleUIFactory(ConsoleInputGetter inputGetter, IUserInputProcess controllerLogic) implements UIFactory {
    @Override
    public Printer getPrinter() {
        return new Printer(System.out::println);
    }

    @Override
    public IController getController() {
        return new CustomController(inputGetter, controllerLogic);
    }
}
