package ru.pylaev.toDoProject.presentLayer.controller.controllerLogic;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.dataAccessLayer.Task;

import java.util.List;
import java.util.function.BiConsumer;

@Component
public class ConsoleGraphLogic implements BiConsumer<String, List<Task>> {
    @Override
    public void accept(String s, List<Task> tasks) {
        String MAIN_COLOR = "\u001b[36m";
        String ALERT_COLOR = "\u001b[33m";
        String style = (tasks == null || tasks.size() < 1) ? ALERT_COLOR : MAIN_COLOR;
        System.out.println(style + "*******************************************************");
    }
}
