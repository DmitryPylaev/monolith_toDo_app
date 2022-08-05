package ru.pylaev.toDoProject.presentLayer.runnableUi.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;
import ru.pylaev.toDoProject.presentLayer.runnableUi.BaseRunnableUI;
import ru.pylaev.toDoProject.presentLayer.view.View;

import java.util.Arrays;
import java.util.Scanner;

@Component
public class ConsoleUserInterface extends BaseRunnableUI {
    private final Scanner scanner = new Scanner((System.in)).useDelimiter("\n");

    @Autowired
    public ConsoleUserInterface(UiState uiState, View view) {
        super(uiState, view);
    }

    @Override
    public void showStartView() {
        System.out.println(view.getMessage());
    }

    @Override
    public void processUserInput() {
        view.setTasks(UiStateService.processUserInput(scanner.next(), uiState));
        view.setMessage(uiState.getStep().toString());
        Arrays.stream(view.getTasks()).forEach(System.out::println);
        System.out.println(view.getMessage());
    }
}
