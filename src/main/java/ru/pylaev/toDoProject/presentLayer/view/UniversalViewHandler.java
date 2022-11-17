package ru.pylaev.toDoProject.presentLayer.view;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.abstractions.Observer;
import ru.pylaev.util.ListToNumberingArrayConverter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Component
@Scope("prototype")
@Getter
@EqualsAndHashCode
public class UniversalViewHandler implements Observer {
    private String[] arrTask;
    private String message = ToDoMain.PROPERTIES.get("askOwner");
    @EqualsAndHashCode.Exclude @Setter private IRunnableView runnableUi;

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
        if (runnableUi != null) {
            runnableUi.display(stringBuilder.toString());
        }
        return stringBuilder.toString();
    }

    public Supplier<String> getRequestSupplier() {
        if (runnableUi!=null) return () -> getNotEmptyInput(runnableUi);
        else throw new UnsupportedOperationException("Не задан UI");
    }

    private static String getNotEmptyInput(IRunnableView ui) {
        ui.setNull();
        String result = null;
        try {
            while (result == null) {
                result = ui.getUserInput();
                TimeUnit.MILLISECONDS.sleep(250);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
