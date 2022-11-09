package ru.pylaev.toDoProject.presentLayer.view;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.Observer;
import ru.pylaev.util.ListToNumberingArrayConverter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Component
@Scope("prototype")
@Getter
@EqualsAndHashCode
public class View implements Observer {
    private String[] arrTask;
    private String message = ToDoMain.PROPERTIES.get("askOwner");
    @EqualsAndHashCode.Exclude @Setter private Consumer<String> printer;

    @Override
    public void update(String message, List<Task> tasks) {
        this.message = message;
        arrTask = ListToNumberingArrayConverter.convert(tasks);
        show();
    }

    public String show() {
        var stringBuilder = new StringBuilder();
        if (arrTask != null && arrTask.length > 0) {
            Arrays.stream(arrTask).forEach(s -> stringBuilder.append(s).append("\n"));
        }
        stringBuilder.append(message);
        if (printer != null) {
            printer.accept(stringBuilder.toString());
        }
        return stringBuilder.toString();
    }
}
