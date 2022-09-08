package ru.pylaev.toDoProject.businessLogicLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pylaev.toDoProject.ToDoMain;

import java.util.ArrayList;

@Service
public class UiStateService {
    private static TaskRepository taskRepository;

    @Autowired
    private void setTaskRepository (TaskRepository t) {
        taskRepository = t;
    }

    public static boolean checkInputBeforeContinue(String userInput, UiStateModel uiStateModel) {
        if (userInput==null) return false;
        else if (userInput.equals(ToDoMain.PROPERTIES.get("commandExit"))) {
            uiStateModel.reset();
            return false;
        }
        return true;
    }

    public static void getEmptyRespond(UiStateModel uiStateModel) {
        uiStateModel.notifyObservers(new ArrayList<>());
    }

    public static void getFullRespond (String userInput, UiStateModel uiStateModel) {
        uiStateModel.manageOwner(userInput);
        uiStateModel.manageTasks(userInput, taskRepository);
        uiStateModel.notifyObservers(taskRepository.getAll(uiStateModel.getOwner()));
    }
}
