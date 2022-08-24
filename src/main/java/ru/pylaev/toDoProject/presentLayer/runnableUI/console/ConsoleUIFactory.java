package ru.pylaev.toDoProject.presentLayer.runnableUI.console;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.runnableUI.*;

@Component
public record ConsoleUIFactory(ConsoleInputGetter inputGetter) implements UIFactory {
    @Override
    public CustomPrinter getPrinter() {
        return new SimplePrinter(System.out::println);
    }

    @Override
    public ControllerInterface getController() {
        return new CustomController(inputGetter);
    }
}
