package ru.pylaev.toDoProject.businessLogicLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.util.ListToNumberingArrayConverter;

import java.util.List;

@Service
public class UiStateService {
    private static TaskRepository taskRepository;

    @Autowired
    private void setTaskRepository (TaskRepository t) {
        taskRepository = t;
    }

    public static void processUserInput(String userInput, UiStateModel uiStateModel) {
        Respond respond = getRespond(userInput, uiStateModel);
        uiStateModel.notifyObservers(respond);
    }

    private static Respond getRespond(String userInput, UiStateModel uiStateModel) {
        if (!checkInputBeforeContinue(userInput, uiStateModel)) return getEmptyRespond();
        else return getFullRespond(userInput, uiStateModel);
    }

    private static boolean checkInputBeforeContinue(String userInput, UiStateModel uiStateModel) {
        if (userInput==null) return false;
        else if (userInput.equals(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("commandExit"))) {
            uiStateModel.reset();
            return false;
        }
        return true;
    }

    private static Respond getEmptyRespond() {
        return new Respond(new String[]{});
    }

    private static Respond getFullRespond (String userInput, UiStateModel uiStateModel) {
        uiStateModel.manageOwner(userInput);
        uiStateModel.manageTasks(userInput, taskRepository);
        List<Task> tasks = taskRepository.getAll(uiStateModel.getOwner());
        String[] tasksList = ListToNumberingArrayConverter.convert(tasks);
        return new Respond(tasksList);
    }
}
