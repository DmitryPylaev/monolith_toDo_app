package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomPrinter;
import ru.pylaev.toDoProject.presentLayer.runnableUI.ControllerInterface;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomController;
import ru.pylaev.toDoProject.presentLayer.runnableUI.UIFactory;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Component
public final class WindowUIFactory implements UIFactory {
    private final WindowInputGetter inputGetter;
    private WindowPrinter windowPrinter;

    @Autowired
    public WindowUIFactory(WindowInputGetter inputGetter) {
        this.inputGetter = inputGetter;
    }

    @Autowired
    private void setWindowPrinter(WindowPrinter windowPrinter) {
        this.windowPrinter = windowPrinter;
    }

    @Override
    public CustomPrinter getPrinter() {
        return windowPrinter;
    }

    @Override
    public ControllerInterface getController(View view) {
        inputGetter.setTextField(windowPrinter.getTextField());
        return new CustomController(inputGetter, view);
    }
}
