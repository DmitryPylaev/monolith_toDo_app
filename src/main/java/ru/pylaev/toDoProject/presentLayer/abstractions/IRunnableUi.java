package ru.pylaev.toDoProject.presentLayer.abstractions;

public interface IRunnableUi {
    String getUserInput();

    void setNull();

    String getNotEmptyInput();
}
