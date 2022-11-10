package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUIFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.Controller;
import ru.pylaev.toDoProject.presentLayer.ui.PlainUiFactory;

import java.util.function.Consumer;

@Component
public record WindowUIFactory (PlainUiFactory plainUiFactory, Window window) implements RunnableUIFactory {
    @Override
    public Consumer<String> getPrinter() {
        return window::display;
    }

    @Override
    public IController getController() {
        return new Controller(new WindowInputGetter(window.getTextField()), plainUiFactory().getView());
    }

    public PlainUiFactory getSimpleUiFactory() {
        return plainUiFactory;
    }
}
