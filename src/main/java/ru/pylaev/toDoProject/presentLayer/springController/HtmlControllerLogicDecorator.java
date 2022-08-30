package ru.pylaev.toDoProject.presentLayer.springController;

import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.ControllerLogicInterface;
import ru.pylaev.toDoProject.presentLayer.view.View;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ClassCanBeRecord")
public class HtmlControllerLogicDecorator implements ControllerLogicInterface {
    private final ControllerLogicInterface controllerLogic;

    public HtmlControllerLogicDecorator(ControllerLogicInterface controllerLogic) {
        this.controllerLogic = controllerLogic;
    }

    @Override
    public void processUserInput(String userInput, UiStateModel uiStateModel) {
        controllerLogic.processUserInput(userInput, uiStateModel);
    }

    public Map<String, Object> getParam (View view) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", view.getMessage());
        map.put("tasks", view.getTasks());
        return map;
    }

    public String getColor(View view) {
        String[] tasks = view.getTasks();
        String color = "background:" + ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("mainColor");
        if (tasks == null || tasks.length<1) {
            color = "background:"+ ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("alertColor");
        }
        return color;
    }
}
