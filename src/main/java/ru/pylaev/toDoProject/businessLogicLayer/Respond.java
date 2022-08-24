package ru.pylaev.toDoProject.businessLogicLayer;

public class Respond {
    private final String[] tasks;

    public Respond(String[] tasks) {
        this.tasks = tasks;
    }

    public String[] getTasks() {
        return tasks;
    }

    public boolean isEmpty() {
        return tasks.length<1;
    }
}
