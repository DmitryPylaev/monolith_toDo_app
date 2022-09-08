package ru.pylaev.toDoProject.presentLayer;

import ru.pylaev.toDoProject.dataAccessLayer.Task;

import java.util.List;

public interface Observer {
    void update (String message, List<Task> tasks);
}
