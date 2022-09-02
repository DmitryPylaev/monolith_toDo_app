package ru.pylaev.toDoProject.businessLogicLayer;

public record Respond(String[] tasks) {
    public String[] getTasks() {
        return tasks;
    }
}
