package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.ControllerLogicInterface;
import ru.pylaev.toDoProject.presentLayer.MainControllerLogic;
import ru.pylaev.toDoProject.presentLayer.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomPrinter;
import ru.pylaev.toDoProject.presentLayer.runnableUI.UIFactory;

@Component
public final class WindowUIFactory implements UIFactory {
    private final WindowInputGetter inputGetter;
    private final WindowPrinter windowPrinter;
    private final ControllerLogicInterface controllerLogic;

    @Autowired
    public WindowUIFactory(WindowInputGetter inputGetter, WindowPrinter windowPrinter, MainControllerLogic controllerLogic) {
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
