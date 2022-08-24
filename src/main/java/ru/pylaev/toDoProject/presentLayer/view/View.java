package ru.pylaev.toDoProject.presentLayer.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.businessLogicLayer.Respond;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomPrinter;
import ru.pylaev.toDoProject.presentLayer.Observer;

import java.util.Arrays;
import java.util.Objects;

@Component
@Scope("prototype")
public class View implements Observer {
    private String[] tasks;
    private String message = ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askOwner");
    private CustomPrinter printer;

    public void setPrinter(CustomPrinter printer) {
        this.printer = printer;
    }

    public void update(String message, Respond respond) {
        this.message = message;
        tasks = respond.getTasks();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof View view)) return false;
        if (!Arrays.deepEquals(tasks, view.tasks)) return false;
        return Objects.equals(message, view.message);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(tasks);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
