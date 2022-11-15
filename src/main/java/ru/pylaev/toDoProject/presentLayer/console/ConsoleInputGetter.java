package ru.pylaev.toDoProject.presentLayer.console;

import ru.pylaev.toDoProject.presentLayer.BaseInputGetter;

import java.util.Scanner;

public class ConsoleInputGetter extends BaseInputGetter {
    private String userInput;
    private final Scanner scanner = new Scanner((System.in)).useDelimiter("\n");

    @Override
    protected String getUserInput() {
        userInput = scanner.next();
        return userInput;
    }

    @Override
    protected void setNull() {
        userInput = null;
    }
}
