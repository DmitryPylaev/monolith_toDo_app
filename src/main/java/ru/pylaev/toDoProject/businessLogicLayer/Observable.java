package ru.pylaev.toDoProject.businessLogicLayer;

import ru.pylaev.toDoProject.presentLayer.Observer;

public interface Observable {
    void addObserver (Observer observer);
    void notifyObservers (Respond respond);
}
