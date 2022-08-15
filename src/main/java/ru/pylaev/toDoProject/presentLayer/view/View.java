package ru.pylaev.toDoProject.presentLayer.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.presentLayer.CustomPrinter;
import ru.pylaev.toDoProject.presentLayer.Observer;

import java.util.Arrays;

@Component
@Scope("prototype")
public class View implements Observer {
    private String[] tasks;
    private String message = ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askOwner");
    private CustomPrinter printer;

    public void setPrinter(CustomPrinter printer) {
        this.printer = printer;
    }

    public void update(String message, String[] tasks) {
        this.message = message;
        this.tasks = tasks;
        show();
    }

    public String show() {
        StringBuilder stringBuilder = new StringBuilder();
        if (tasks != null && tasks.length > 0) {
            Arrays.stream(tasks).forEach(s -> stringBuilder.append(s).append("\n"));
        }
        stringBuilder.append(message);
        if (printer != null) {
            printer.display(String.valueOf(stringBuilder));
        }
        return String.valueOf(stringBuilder);
    }
}
