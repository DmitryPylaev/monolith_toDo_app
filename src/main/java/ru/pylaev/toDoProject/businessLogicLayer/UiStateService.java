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
        if (userInput==null) return new String[]{};
        else if (userInput.equals(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("commandExit"))) {
            uiState.reset();
            return new String[]{};
        }
        if (uiState.getOwner()==null) {
            uiState.setCorrectOwner(userInput);
        }
        uiState.getStep().manageState(userInput, uiState, taskRepository);
        return ListToNumberingArrayConverter.convert(taskRepository.findByOwner(uiState.getOwner()));
    }
}
