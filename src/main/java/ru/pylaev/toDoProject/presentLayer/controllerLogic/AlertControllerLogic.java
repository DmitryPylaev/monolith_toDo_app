package ru.pylaev.toDoProject.presentLayer.controllerLogic;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;

@Component
public class AlertControllerLogic extends SimpleControllerLogic {
    public final static String MAIN_STYLE = "margin-left:120px;width:1295px;";

    public String getStyle(String[] tasks) {
        String color = (tasks == null || tasks.length<1)?"alertColor":"mainColor";
        return MAIN_STYLE + "background:" + ToDoMain.PROPERTIES.get(color);
    }
}
