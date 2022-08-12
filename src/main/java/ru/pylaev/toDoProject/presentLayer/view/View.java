package ru.pylaev.toDoProject.presentLayer.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.presentLayer.runnableUi.CustomPrinter;

import java.util.Arrays;
import java.util.Objects;

@Component
@Scope("prototype")
public class View {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        View view = (View) o;
        return Arrays.equals(tasks, view.tasks) && Objects.equals(message, view.message);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(message);
        result = 31 * result + Arrays.hashCode(tasks);
        return result;
    }
}
