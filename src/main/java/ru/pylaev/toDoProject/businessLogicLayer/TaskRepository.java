package ru.pylaev.toDoProject.businessLogicLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.dataAccessLayer.DAO;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.util.InputChecker;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskRepository {
    private static final String[] TASKS_STATES = new String[] {
            ToDoMain.PROPERTIES.get("statusWait"),
            ToDoMain.PROPERTIES.get("statusDone"),
            ToDoMain.PROPERTIES.get("statusArch")
    };

    private final DAO taskDAO;

    @Autowired
    public TaskRepository(DAO tasksDAO) {
        this.taskDAO = tasksDAO;
    }

    public synchronized List<Task> getAll(String owner) {
        return (taskDAO.findByOwner(owner)).stream()
                .filter(task -> !task.getStatus().equals(ToDoMain.PROPERTIES.get("statusArch")))
                .collect(Collectors.toList());
    }

    public synchronized int saveNewTask(String owner, String taskContent) {
        if (!taskContent.equals(ToDoMain.PROPERTIES.get("commandBack"))) {
            taskDAO.save(new Task(owner, taskContent, new Date(), ToDoMain.PROPERTIES.get("statusWait")));
            return 1;
        }
        return 0;
    }

    public synchronized int updateTask(String owner, String status, int taskIndex) {
        if (status.equals(ToDoMain.PROPERTIES.get("commandBack")) || getAll(owner).size()==0) return 1;

        if (InputChecker.inputSymbolsInArray(status, TASKS_STATES)>0) {
            Task task = taskDAO.findById(getAll(owner)
                    .get(taskIndex-1)
                    .getId())
                    .orElseThrow();
            task.setStatus(status);
            taskDAO.save(task);
            return (getAll(owner).size()>0)?1:0;
        }

        return -1;
    }
}
