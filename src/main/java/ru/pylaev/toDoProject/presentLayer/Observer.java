package ru.pylaev.toDoProject.presentLayer;

import ru.pylaev.toDoProject.businessLogicLayer.Respond;

public interface Observer {
    void update (String message, Respond respond);
}
