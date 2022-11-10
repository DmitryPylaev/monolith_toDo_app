package ru.pylaev.toDoProject.presentLayer.runnableUI.console;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IUserInputProcess;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUIFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.Controller;

import java.util.function.Consumer;

@Component
public record ConsoleUIFactory(IUserInputProcess controllerLogic) implements RunnableUIFactory {
    @Override
    public Consumer<String> getPrinter() {
        return System.out::println;
    }

    @Override
    public IController getController() {
        return new Controller(new ConsoleInputGetter(), controllerLogic);
    }
}
