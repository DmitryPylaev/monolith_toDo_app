package ru.pylaev.toDoProject.presentLayer.runnableUI.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUiFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.Controller;
import ru.pylaev.toDoProject.presentLayer.ui.PlainUiFactory;

@Component
public class ConsoleUiFactory implements RunnableUiFactory {
    private final PlainUiFactory plainUiFactory;

    @Autowired
    public ConsoleUiFactory(PlainUiFactory plainUiFactory) {
        this.plainUiFactory = plainUiFactory;
        plainUiFactory.getView().setPrinter(System.out::println);
    }

    @Override
    public IController getController() {
        return new Controller(new ConsoleInputGetter(), plainUiFactory.getView());
    }

    @Override
    public PlainUiFactory getPlainUiFactory() {
        return plainUiFactory;
    }
}
