package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUIFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.Controller;

import java.util.function.Consumer;

@Component
public record WindowUIFactory (Window window) implements RunnableUIFactory {
    @Override
    public Consumer<String> getPrinter() {
        return window::display;
    }

    @Override
    public IController getController() {
        return new Controller(new WindowInputGetter(window.getTextField()));
    }
}
