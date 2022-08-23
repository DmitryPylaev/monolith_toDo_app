package ru.pylaev.toDoProject.presentLayer.runnableUI.console;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomPrinter;
import ru.pylaev.toDoProject.presentLayer.runnableUI.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;
import ru.pylaev.toDoProject.presentLayer.runnableUI.SimplePrinter;
import ru.pylaev.toDoProject.presentLayer.runnableUI.UIFactory;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Component
public record ConsoleUIFactory(ConsoleInputGetter inputGetter) implements UIFactory {
    @Override
    public CustomPrinter getPrinter() {
        return new SimplePrinter(System.out::println);
    }

    @Override
    public ControllerInterface getController(View view) {
        return new CustomController(inputGetter, view);
    }
}
