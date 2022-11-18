package ru.pylaev.toDoProject.presentLayer.runnable.view;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.abstractions.Observer;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.util.ListToNumberingArrayConverter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Scope("prototype")
@Getter
@EqualsAndHashCode
public abstract class View implements Observer {
    private String[] arrTask;
    private String message = ToDoMain.PROPERTIES.get("askOwner");

    @Override
    public void update(String message, List<Task> tasks) {
        this.message = message;
        arrTask = ListToNumberingArrayConverter.convert(tasks);
        show();
    }

    public void show() {
        var stringBuilder = new StringBuilder();
        if (arrTask != null && arrTask.length > 0) Arrays.stream(arrTask).forEach(s -> stringBuilder.append(s).append("\n"));
        stringBuilder.append(message);
        display(stringBuilder.toString());
    }

    public String getNotEmptyInput() {
        setNull();
        String result = null;
        try {
            while (result == null) {
                result = getUserInput();
                TimeUnit.MILLISECONDS.sleep(250);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected abstract String getUserInput();
    protected abstract void setNull();
    public abstract void display(String content);
}
