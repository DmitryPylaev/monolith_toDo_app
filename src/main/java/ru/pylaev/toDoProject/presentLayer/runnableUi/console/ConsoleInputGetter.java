package ru.pylaev.toDoProject.presentLayer.runnableUi.console;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.runnableUi.CyclicPolling;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableUi;

import java.util.Scanner;

@Component
public class ConsoleInputGetter implements IRunnableUi {
    private String userInput;
    private final Scanner scanner = new Scanner((System.in)).useDelimiter("\n");

    @Override
    public String getUserInput() {
        userInput = scanner.next();
        return userInput;
    }

    @Override
    public void setNull() {
        userInput = null;
    }

    public String getNotEmptyInput() {
        return CyclicPolling.getNotEmptyInput(this);
    }
}
