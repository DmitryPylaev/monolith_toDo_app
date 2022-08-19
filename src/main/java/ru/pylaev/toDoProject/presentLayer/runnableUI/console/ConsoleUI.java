package ru.pylaev.toDoProject.presentLayer.runnableUI.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.runnableUI.RunnableUI;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Component
public class ConsoleUI extends RunnableUI {
    @Autowired
    public ConsoleUI(View view, UiStateModel uiStateModel, ConsoleUIFactory factory) {
        super(view, uiStateModel);
        view.setPrinter(factory.getPrinter());
        setController(factory.getController());
    }
}
