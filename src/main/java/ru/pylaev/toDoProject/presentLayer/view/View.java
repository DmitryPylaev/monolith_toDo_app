package ru.pylaev.toDoProject.presentLayer.view;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.businessLogicLayer.Respond;
import ru.pylaev.toDoProject.presentLayer.Observer;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomPrinter;

import java.util.Arrays;

@Component
@Scope("prototype")
@Getter
@EqualsAndHashCode
public class View implements Observer {
    private String[] tasks;
    private String message = ToDoMain.PROPERTIES.get("askOwner");
    @EqualsAndHashCode.Exclude @Setter private CustomPrinter printer;

    @Override
    public void update(String message, Respond respond) {
        this.message = message;
        tasks = respond.getTasks();
        show();
    }

    public String show() {
        var stringBuilder = new StringBuilder();
        if (tasks != null && tasks.length > 0) {
            Arrays.stream(tasks).forEach(s -> stringBuilder.append(s).append("\n"));
        }
        stringBuilder.append(message);
        if (printer != null) {
            printer.display(stringBuilder.toString());
        }
        return stringBuilder.toString();
    }
}
