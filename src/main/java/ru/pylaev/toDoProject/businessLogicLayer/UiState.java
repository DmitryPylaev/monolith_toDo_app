package ru.pylaev.toDoProject.businessLogicLayer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static ru.pylaev.util.InputChecker.inputSymbolsInArray;

@Component
@Scope("prototype")
public class UiState {
    public static final String[] INVALID_SYMBOLS = new String[] {" ", "\\", "|", "/", ":", "?", "\"", "<", ">"};

    private LogicStep logicStep = LogicStep.ASK_OWNER;
    private int currentTaskIndex;
    private String owner;

    public LogicStep getStep( ) {
        return logicStep;
    }

    public void setStep(LogicStep logicStep) {
        this.logicStep = logicStep;
    }

    public int getCurrentTaskIndex( ) {
        return currentTaskIndex;
    }

    public void setCurrentTaskIndex(int currentTaskIndex) {
        this.currentTaskIndex = currentTaskIndex;
    }

    public String getOwner ( ) {
        return owner;
    }

    public void manageOwner(String owner) {
        if (this.owner==null && (logicStep.equals(LogicStep.ASK_OWNER)) && (inputSymbolsInArray(owner, INVALID_SYMBOLS) < 0)) {
            this.owner = owner;
            logicStep = LogicStep.ASK_NUMBER;
        }
    }

    public void manageTasks(String userInput, TaskRepository taskRepository) {
        logicStep.manageState(userInput, this, taskRepository);
    }

    public void reset() {
        this.logicStep = LogicStep.ASK_OWNER;
        this.owner = null;
        this.currentTaskIndex = 0;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UiState uiState = (UiState) o;
        if (currentTaskIndex != uiState.currentTaskIndex) return false;
        if (!Objects.equals(logicStep, uiState.logicStep)) return false;
        return Objects.equals(owner, uiState.owner);
    }

    @Override
    public int hashCode ( ) {
        int result = logicStep != null ? logicStep.hashCode() : 0;
        result = 31 * result + currentTaskIndex;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
