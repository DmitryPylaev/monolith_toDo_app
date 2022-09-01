package ru.pylaev.toDoProject.presentLayer.spring;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.presentLayer.SimpleControllerLogic;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Component
public class AlertControllerLogic extends SimpleControllerLogic {

    public String getColor(View view) {
        String[] tasks = view.getTasks();
        String color = "background:" + ToDoMain.PROPERTIES.get("mainColor");
        if (tasks == null || tasks.length<1) {
            color = "background:"+ ToDoMain.PROPERTIES.get("alertColor");
        }
        return color;
    }
}
