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

    public static void processUserInput(String userInput, UiStateModel uiStateModel) {
        Respond respond = getRespond(userInput, uiStateModel);
        uiStateModel.notifyObservers(respond);
    }

    private static Respond getRespond(String userInput, UiStateModel uiStateModel) {
        if (!checkInputBeforeContinue(userInput, uiStateModel)) return new Respond(new String[]{});
        uiStateModel.manageOwner(userInput);
        uiStateModel.manageTasks(userInput, taskRepository);
        return new Respond(ListToNumberingArrayConverter.convert(taskRepository.getAll(uiStateModel.getOwner())));
    }

    private static boolean checkInputBeforeContinue(String userInput, UiStateModel uiStateModel) {
        if (userInput==null) return false;
        else if (userInput.equals(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("commandExit"))) {
            uiStateModel.reset();
            return false;
        }
        return true;
    }
}
