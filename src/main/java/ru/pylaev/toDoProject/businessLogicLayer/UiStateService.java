package ru.pylaev.toDoProject.businessLogicLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.util.ListToNumberingArrayConverter;

@Service
public class UiStateService {
    private static TaskRepository taskRepository;

    @Autowired
    private void setTaskRepository (TaskRepository t) {
        taskRepository = t;
    }

    public static String[] processUserInput(String userInput, UiState uiState) {
        if (!checkInputBeforeContinue(userInput, uiState)) return new String[]{};
        uiState.manageOwner(userInput);
        uiState.manageTasks(userInput, taskRepository);
        return ListToNumberingArrayConverter.convert(taskRepository.getAll(uiState.getOwner()));
    }

    private static boolean checkInputBeforeContinue(String userInput, UiState uiState) {
        if (userInput==null) return false;
        else if (userInput.equals(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("commandExit"))) {
            uiState.reset();
            return false;
        }
        return true;
    }
}
