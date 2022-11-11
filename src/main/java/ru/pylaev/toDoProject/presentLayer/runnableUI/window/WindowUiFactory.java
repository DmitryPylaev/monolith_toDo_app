package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUiFactory;
import ru.pylaev.toDoProject.presentLayer.ControllerLogic;
import ru.pylaev.toDoProject.presentLayer.runnableUI.SimpleController;
import ru.pylaev.toDoProject.presentLayer.ui.PlainUiFactory;

@Component
public class WindowUiFactory implements RunnableUiFactory {
    private final PlainUiFactory plainUiFactory;
    private final Window window;

    @Autowired
    public WindowUiFactory(PlainUiFactory plainUiFactory, Window window) {
        this.plainUiFactory = plainUiFactory;
        this.window = window;
        plainUiFactory.getView().setPainter(window::display);
    }

    @Override
    public IController getController() {
        return new SimpleController(new WindowInputGetter(window.getTextField()), new ControllerLogic());
    }

    @Override
    public PlainUiFactory getPlainUiFactory() {
        return plainUiFactory;
    }
}
