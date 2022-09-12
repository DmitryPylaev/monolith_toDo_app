package ru.pylaev.toDoProject.presentLayer.spring;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.presentLayer.SimpleControllerLogic;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Component
public class AlertControllerLogic extends SimpleControllerLogic {

    public String getStyle(View view) {
        var tasks = view.getArrTask();
        String style = "margin-left:120px; width:1295px; background:" + ToDoMain.PROPERTIES.get("mainColor");
        if (tasks == null || tasks.length<1) {
            style = "margin-left:120px; width:1295px; background:"+ ToDoMain.PROPERTIES.get("alertColor");
        }
        return style;
    }
}
