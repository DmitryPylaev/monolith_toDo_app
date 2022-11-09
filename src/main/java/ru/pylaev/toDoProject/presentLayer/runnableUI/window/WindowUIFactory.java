package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IUserInputProcess;
import ru.pylaev.toDoProject.presentLayer.SimpleControllerLogic;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;
import ru.pylaev.toDoProject.presentLayer.abstractions.UIFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.Printer;

@Component
public final class WindowUIFactory implements UIFactory {
    private final WindowInputGetter inputGetter;
    private final Window window;
    private final IUserInputProcess controllerLogic;

    @Autowired
    public WindowUIFactory(WindowInputGetter inputGetter, Window window, SimpleControllerLogic controllerLogic) {
        this.inputGetter = inputGetter;
        this.window = window;
        this.controllerLogic = controllerLogic;
        inputGetter.setTextField(window.getTextField());
    }

    @Override
    public Printer getPrinter() {
        return new Printer(window::display);
    }

    @Override
    public IController getController() {
        return new CustomController(inputGetter, controllerLogic);
    }
}
