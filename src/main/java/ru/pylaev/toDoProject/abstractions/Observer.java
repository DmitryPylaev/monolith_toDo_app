package ru.pylaev.toDoProject.abstractions;

import ru.pylaev.toDoProject.dataAccessLayer.Task;

import java.util.List;

public interface Observer {
    void update (String message, List<Task> tasks);
}
