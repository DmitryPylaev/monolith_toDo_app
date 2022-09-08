package ru.pylaev.toDoProject.businessLogicLayer;

import lombok.AllArgsConstructor;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.util.InputChecker;

import java.util.Date;

@AllArgsConstructor
public enum LogicStep {
    ASK_OWNER(ToDoMain.PROPERTIES.get("askOwner")),
    ASK_NUMBER(ToDoMain.PROPERTIES.get("askNumber")) {
        @Override
        void manageState(String userInput, UiStateModel uiStateModel, TaskRepository taskRepository) {
            var tasksList = taskRepository.getAll(uiStateModel.getOwner());
            int index = validateIndex(userInput, tasksList.size());
            if (index == 0) {
                uiStateModel.setLogicStep(LogicStep.ASK_NEW);
            }
            else if (index > 0) {
                uiStateModel.setLogicStep(LogicStep.ASK_STATUS);
                uiStateModel.setCurrentTaskIndex(index);
            }
        }
    },
    ASK_NEW(ToDoMain.PROPERTIES.get("askNew")) {
        @Override
        void manageState(String rawUserInput, UiStateModel uiStateModel, TaskRepository taskRepository) {
            String owner = uiStateModel.getOwner();
            String userInput = rawUserInput + " (" + Translator.translate(rawUserInput) + ") ";
            String data = new Date().toString();
            String status = ToDoMain.PROPERTIES.get("statusWait");
            taskRepository.saveNewTask(owner, userInput, data, status);
            uiStateModel.setLogicStep(LogicStep.ASK_NUMBER);
        }
    },
    ASK_STATUS(ToDoMain.PROPERTIES.get("askStatus")) {
        @Override
        void manageState(String userInput, UiStateModel uiStateModel, TaskRepository taskRepository) {
            int changeStatusResult = taskRepository.updateTask(uiStateModel.getOwner(), userInput, uiStateModel.getCurrentTaskIndex());
            if (changeStatusResult>0) {
                uiStateModel.setLogicStep(LogicStep.ASK_NUMBER);
            }
            else if (changeStatusResult==0) {
                uiStateModel.setLogicStep(LogicStep.ASK_NEW);
            }
        }
    };

    private final String content;

    @Override
    public String toString() {return content;}

    void manageState (String userInput, UiStateModel uiStateModel, TaskRepository taskRepository) {}

    private static int validateIndex(String userInput, int size) {
        if (size==0 || userInput.equals(ToDoMain.PROPERTIES.get("commandNew"))) {
            return 0;
        }
        else if (!userInput.equals(ToDoMain.PROPERTIES.get("commandBack"))) {
            int taskIndex = InputChecker.isValidIndex(userInput, size);
            if (taskIndex>-1) return taskIndex;
        }
        return -1;
    }
}
