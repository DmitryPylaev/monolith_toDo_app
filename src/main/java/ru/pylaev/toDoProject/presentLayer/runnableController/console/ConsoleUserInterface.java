package ru.pylaev.toDoProject.presentLayer.runnableController.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.runnableController.RunnableController;
import ru.pylaev.toDoProject.presentLayer.runnableController.SimplePrinter;
import ru.pylaev.toDoProject.presentLayer.view.View;

import java.util.Scanner;

@Component
public class ConsoleUserInterface extends RunnableController {
    private final Scanner scanner = new Scanner((System.in)).useDelimiter("\n");

    @Autowired
    public ConsoleUserInterface(View view, UiStateModel uiStateModel) {
        super(view, uiStateModel);
        view.setPrinter(new SimplePrinter(System.out::println));
    }

    @Override
    public String getInput() {
        return scanner.next();
    }
}
