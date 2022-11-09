package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IUserInputProcess;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUIFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;

import java.util.function.Consumer;

@Component
public record WindowUIFactory (WindowInputGetter inputGetter, Window window, IUserInputProcess controllerLogic) implements RunnableUIFactory {
    @Override
    public Consumer<String> getPrinter() {return window::display;}

    @Override
    public IController getController() {
        inputGetter.setTextField(window.getTextField());
        return new CustomController(inputGetter, controllerLogic);
    }
}
