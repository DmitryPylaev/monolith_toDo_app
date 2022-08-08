package ru.pylaev.toDoProject.businessLogicLayer;

import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.util.InputChecker;

import java.util.List;

public enum LogicStep {
    ASK_OWNER(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askOwner")),
    ASK_NUMBER(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askNumber")) {
        @Override
        void manageState(String userInput, UiState uiState, TaskRepository taskRepository) {
            List<Task> tasksList = taskRepository.getAll(uiState.getOwner());
            int index = validateIndex(userInput, tasksList.size());
            if (index == 0) {
                uiState.setStep(LogicStep.ASK_NEW);
            }
            else if (index > 0) {
                uiState.setStep(LogicStep.ASK_STATUS);
                uiState.setCurrentTaskIndex(index);
            }
        }
    },
    ASK_NEW(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askNew")) {
        @Override
        void manageState(String userInput, UiState uiState, TaskRepository taskRepository) {
            taskRepository.saveNewTask(uiState.getOwner(), userInput);
            uiState.setStep(LogicStep.ASK_NUMBER);
        }
    },
    ASK_STATUS(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askStatus")) {
        @Override
        void manageState(String userInput, UiState uiState, TaskRepository taskRepository) {
            int changeStatusResult = taskRepository.updateTask(uiState.getOwner(), userInput, uiState.getCurrentTaskIndex());
            if (changeStatusResult>0) {
                uiState.setStep(LogicStep.ASK_NUMBER);
            }
            else if (changeStatusResult==0) {
                uiState.setStep(LogicStep.ASK_NUMBER);
            }
        }
    };

    private final String content;

    LogicStep(String content) {
        this.content = content;
    }

    void manageState (String userInput, UiState uiState, TaskRepository taskRepository) {}

    @Override
    public String toString() {
        return content;
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
