package ru.pylaev.toDoProject.presentLayer.runnableUI.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUiFactory;
import ru.pylaev.toDoProject.presentLayer.ControllerLogic;
import ru.pylaev.toDoProject.presentLayer.ui.PlainUiFactory;

@Component
public class ConsoleUiFactory implements RunnableUiFactory {
    private final PlainUiFactory plainUiFactory;

    @Autowired
    public ConsoleUiFactory(PlainUiFactory plainUiFactory) {
        this.plainUiFactory = plainUiFactory;
        plainUiFactory.getView().setPainter(System.out::println);
    }

    @Override
    public IController getController() {
        return new ConsoleController(new ConsoleInputGetter(), new ControllerLogic());
    }

    @Override
    public PlainUiFactory getPlainUiFactory() {
        return plainUiFactory;
    }
}
