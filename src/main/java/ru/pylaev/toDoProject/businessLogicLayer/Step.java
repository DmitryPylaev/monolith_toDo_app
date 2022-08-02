package ru.pylaev.toDoProject.businessLogicLayer;

import ru.pylaev.toDoProject.ToDoMain;

public enum Step {
    ASK_OWNER(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askOwner")),
    ASK_NUMBER(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askNumber")),
    ASK_NEW(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askNew")),
    ASK_STATUS(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askStatus"));

    private final String content;

    Step(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
