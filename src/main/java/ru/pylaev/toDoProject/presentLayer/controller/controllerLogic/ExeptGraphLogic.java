package ru.pylaev.toDoProject.presentLayer.controller.controllerLogic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.dataAccessLayer.Task;

import java.util.List;
import java.util.function.BiConsumer;

@Component
@Primary
public class ExeptGraphLogic implements BiConsumer<String, List<Task>> {
    @Override
    public void accept(String s, List<Task> tasks) {
        //        throw new UnsupportedOperationException("Этот контроллер пока не умеет управлять представлением");
    }
}
