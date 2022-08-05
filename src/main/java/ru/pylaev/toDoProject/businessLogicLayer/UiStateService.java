package ru.pylaev.toDoProject.businessLogicLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.util.InputChecker;
import ru.pylaev.util.ListToNumberingArrayConverter;

import java.util.List;

@Service
public class UiStateService {
    private static TaskRepository taskRepository;

    @Autowired
    private void setTaskRepository (TaskRepository t) {
        taskRepository = t;
    }

    public static String[] processUserInput(String userInput, UiState uiState) {
        if (userInput==null) {
            return new String[]{};
        }
        else if (userInput.equals(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("commandExit"))) {
            uiState.reset();
            return new String[]{};
        }
        if (uiState.getOwner()==null) {
            uiState.setCorrectOwner(userInput);
        }
        return  getStepResult(userInput, uiState);
    }

    private static String[] getStepResult(String userInput, UiState uiState) {
        switch (uiState.getStep()) {
            case ASK_NUMBER -> {
                List<Task> tasksList = taskRepository.findByOwner(uiState.getOwner());
                int index = validateIndex(userInput, tasksList.size());
                if (index == 0) {
                    uiState.setStep(Step.ASK_NEW);
                }
                else if (index > 0) {
                    uiState.setStep(Step.ASK_STATUS);
                    uiState.setCurrentTaskIndex(index);
                }
            }
            case ASK_NEW -> {
                taskRepository.saveNewTask(uiState.getOwner(), userInput);
                uiState.setStep(Step.ASK_NUMBER);
            }
            case ASK_STATUS -> {
                int changeStatusResult = taskRepository.updateTask(uiState.getOwner(), userInput, uiState.getCurrentTaskIndex());
                if (changeStatusResult>0) {
                    uiState.setStep(Step.ASK_NUMBER);
                }
                else if (changeStatusResult==0) {
                    uiState.setStep(Step.ASK_NUMBER);
                }
            }
        }
        return ListToNumberingArrayConverter.convert(taskRepository.findByOwner(uiState.getOwner()));
    }

    private static int validateIndex(String userInput, int size) {
        if (size==0 || userInput.equals(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("commandNew"))) {
            return 0;
        }
        else if (!userInput.equals(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("commandBack"))) {
            var taskIndex = InputChecker.isValidIndex(userInput, size);
            if (taskIndex>-1) return taskIndex;
        }
        return -1;
    }
}
