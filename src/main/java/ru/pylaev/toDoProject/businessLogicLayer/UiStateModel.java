package ru.pylaev.toDoProject.businessLogicLayer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.Observer;

import java.util.ArrayList;
import java.util.List;

import static ru.pylaev.util.InputChecker.inputSymbolsInArray;

@Component
@Scope("prototype")
@Getter
@EqualsAndHashCode
public class UiStateModel implements Observable{
    public static final String[] INVALID_SYMBOLS = new String[] {" ", "\\", "|", "/", ":", "?", "\"", "<", ">"};

    @EqualsAndHashCode.Exclude private final List<Observer> observers = new ArrayList<>();
    private String owner;
    @Setter private LogicStep logicStep = LogicStep.ASK_OWNER;
    @Setter private int currentTaskIndex;

    public void addObserver (Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers (Respond respond) {
        for (Observer observer:observers) {
            observer.update(logicStep.toString(), respond);
        }
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
}
