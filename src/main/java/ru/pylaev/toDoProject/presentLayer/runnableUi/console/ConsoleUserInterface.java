package ru.pylaev.toDoProject.presentLayer.runnableUi.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.presentLayer.runnableUi.BaseRunnableUI;
import ru.pylaev.toDoProject.presentLayer.runnableUi.SimplePrinter;
import ru.pylaev.toDoProject.presentLayer.view.View;

import java.util.Scanner;

@Component
public class ConsoleUserInterface extends BaseRunnableUI {
    private final Scanner scanner = new Scanner((System.in)).useDelimiter("\n");

    @Autowired
    public ConsoleUserInterface(View view, UiState uiState) {
        super(view, uiState);
        view.setPrinter(new SimplePrinter(System.out::println));
    }

    @Override
    public String getInput() {
        return scanner.next();
    }
}
