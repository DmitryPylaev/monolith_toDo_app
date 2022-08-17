package ru.pylaev.toDoProject.presentLayer.runnableUI.console;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.runnableUI.InputGetter;

import java.util.Scanner;

@Component
public class ConsoleInputGetter extends InputGetter {
    private String userInput;
    private final Scanner scanner = new Scanner((System.in)).useDelimiter("\n");

    @Override
    public String get() {
        userInput = scanner.next();
        return userInput;
    }

    @Override
    public void setNull() {
        userInput = null;
    }
}
