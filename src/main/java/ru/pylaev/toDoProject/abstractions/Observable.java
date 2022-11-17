package ru.pylaev.toDoProject.abstractions;

import ru.pylaev.toDoProject.dataAccessLayer.Task;

import java.util.List;

public interface Observable {
    void addObserver (Observer observer);
    void notifyObservers (List<Task> tasks);
}
