package ru.pylaev.toDoProject.businessLogicLayer;

public record Respond(String[] tasks, boolean emptyRespond) {

    public String[] getTasks() {
        return tasks;
    }

    public boolean isEmptyRespond() {
        return emptyRespond;
    }
}
