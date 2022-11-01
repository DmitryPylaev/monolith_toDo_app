package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.abstractions.ControllerLogicInterface;
import ru.pylaev.toDoProject.presentLayer.SimpleControllerLogic;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;
import ru.pylaev.toDoProject.presentLayer.abstractions.CustomPrinter;
import ru.pylaev.toDoProject.presentLayer.abstractions.UIFactory;

@Component
public final class WindowUIFactory implements UIFactory {
    private final WindowInputGetter inputGetter;
    private final WindowPrinter windowPrinter;
    private final ControllerLogicInterface controllerLogic;

    @Autowired
    public WindowUIFactory(WindowInputGetter inputGetter, WindowPrinter windowPrinter, SimpleControllerLogic controllerLogic) {
        this.inputGetter = inputGetter;
        this.windowPrinter = windowPrinter;
        this.controllerLogic = controllerLogic;
        inputGetter.setTextField(windowPrinter.getTextField());
    }

    @Override
    public CustomPrinter getPrinter() {
        return windowPrinter;
    }

    @Override
    public ControllerInterface getController() {
        return new CustomController(inputGetter, controllerLogic);
    }
}
