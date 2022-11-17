package ru.pylaev.toDoProject.presentLayer.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleView implements IRunnableView {
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

    @Override
    public void display(String content) {
        System.out.println(content);
    }
}
