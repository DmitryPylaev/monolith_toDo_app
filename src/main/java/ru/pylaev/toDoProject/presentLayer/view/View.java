package ru.pylaev.toDoProject.presentLayer.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;

import java.util.Arrays;
import java.util.Objects;

@Component
@Scope("prototype")
public class View {
    private String[] tasks;
    private String message = ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askOwner");
//    private BaseRunnableUI ui;
//
//    public View(BaseRunnableUI ui) {
//        this.ui = ui;
//    }

    public String[] getTasks() {
        return tasks;
    }

    public String getMessage() {
        return message;
    }

    public void update (String message, String[] tasks) {
        this.message = message;
        this.tasks = tasks;
//        ui.respondsToRequests();
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
